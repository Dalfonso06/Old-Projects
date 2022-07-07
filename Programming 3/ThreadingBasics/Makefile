all: threading

threading: threading.o
	gcc threading.o -o threading

threading.o: threading.c
	gcc -c threading.c -o threading.o

clean:
	rm -f threading *.o core *~