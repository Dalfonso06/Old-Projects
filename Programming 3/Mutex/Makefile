all: mutex

mutex: mutex.o
	gcc mutex.o -o mutex

mutex.o: mutex.c
	gcc -c mutex.c -o mutex.o

clean:
	rm -f mutex *.o core *~