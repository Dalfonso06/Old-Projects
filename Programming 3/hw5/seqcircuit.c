#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <sys/time.h>

/* Return 1 if 'i'th bit of 'n' is 1; 0 otherwise */
#define EXTRACT_BIT(n,i) ((n&(1<<i))?1:0)
int THREAD_COUNT;
int count = 0;

pthread_mutex_t mutex;

int check_circuit (int z, int threadid) {
  int v[16];        /* Each element is a bit of z */
  int i;

  for (i = 0; i < 16; i++) v[i] = EXTRACT_BIT(z,i);
  if ((v[0] || v[1]) && (!v[1] || !v[3]) && (v[2] || v[3])
      && (!v[3] || !v[4]) && (v[4] || !v[5])
      && (v[5] || !v[6]) && (v[5] || v[6])
      && (v[6] || !v[15]) && (v[7] || !v[8])
      && (!v[7] || !v[13]) && (v[8] || v[9])
      && (v[8] || !v[9]) && (!v[9] || !v[10])
      && (v[9] || v[11]) && (v[10] || v[11])
      && (v[12] || v[13]) && (v[13] || !v[14])
      && (v[14] || v[15]) && v[1] == 1) {
    printf ("%d) %d%d%d%d%d%d%d%d%d%d%d%d%d%d%d%d\n",
	    threadid,v[0],v[1],v[2],v[3],v[4],v[5],v[6],v[7],v[8],v[9],
	    v[10],v[11],v[12],v[13],v[14],v[15]);
    return 1;
  } else return 0;
}

void *check_circuitThreads(void* num) {

  int tempCount = 0;
  int range = 65536/THREAD_COUNT;
  int *start = (int*) num;
  int end = *start + range;
  int threadid = *start / range;

  for (int i = *start; i <= end; i++) {
    tempCount += check_circuit(i, threadid);
  }

  pthread_mutex_lock(&mutex);
  count += tempCount;
  pthread_mutex_unlock(&mutex);
  
  return NULL;
}

int main (int argc, char *argv[]) 
{
  int i, begin, end, range;
  struct timeval t1, t2;
  pthread_mutex_init(&mutex, NULL); // initialize mutex

  if (argc < 2 || atoi(argv[1]) < 0 || atoi(argv[1]) > 128) {
    return -1;
  } else {
    THREAD_COUNT = atoi(argv[1]);
  }

  // Allocate for the number of threads to be used.
  pthread_t *threads = malloc(sizeof(pthread_t) * THREAD_COUNT);

  range = 65536/THREAD_COUNT;
  begin = 0;
  end = range;

  int numArray[THREAD_COUNT];

  gettimeofday(&t1, 0);
  // All threads begin.
  for (i = 0; i < THREAD_COUNT; i++) {

    numArray[i] = begin;
    pthread_create(&threads[i], NULL, check_circuitThreads, &numArray[i]);

    begin = end + 1;
    end = end + range;
  }

  for (i = 0; i < THREAD_COUNT; i++) {
    pthread_join(threads[i], NULL);
  }
  gettimeofday(&t2, 0);

  printf ("Execution time %fs\n", (t2.tv_sec-t1.tv_sec)+(t2.tv_usec-t1.tv_usec)*1e-6);
  printf("There are %d solutions\n", count);
  
  return 0;
}
