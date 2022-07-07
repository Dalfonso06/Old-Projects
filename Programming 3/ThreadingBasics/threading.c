
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

void *entry_point(void *value) {
	printf("Hello from the second thread\n");

	int *num = (int*) value;

	printf("the value of value is %d\n", *num);
	return NULL;
}

int main (int argc, char* argv[]) {

	pthread_t thread;

	printf("Hello from the first thread\n");
	int num = 123;

	/* Takes four parameters 
		1. Reference to the thread struct
		2. pthread attributes
		3. function that will be the entry point for new thread
		4. value to send your function.*/
	pthread_create(&thread, NULL, entry_point, &num);

	/* What pthread_join does is ensures your main thread
		will wait until your second thread finishes. */
	pthread_join(thread, NULL);


	return 0;
}