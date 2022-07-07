#include <stdio.h>

/* print Fahrenheit-Kelvin table
	for fahr = 0, 10, ..., 100; floating-point version*/

int main() {

	float fahr, kelvin;
	int lower, upper, step;

	lower = 0;
	upper = 100;
	step = 10;

	fahr = lower;
	
	while (fahr <= upper) {

		// Formula for fahrenheit to kelvin conversion.
		kelvin = (fahr - 32.0) * (5.0/9.0) + 273.15;

		printf("%3.0f %6.1f\n", fahr, kelvin);
		fahr = fahr + step;
	}
    
    return 0;
}
