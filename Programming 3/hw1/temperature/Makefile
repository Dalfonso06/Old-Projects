all: temperature

temperature: temperature.o
	gcc temperature.o -o temperature

temperature.o: temperature.c
	gcc -c temperature.c -o temperature.o

# Removes files created using: $ make clean
clean:
	rm -f temperature temperature.o core *~