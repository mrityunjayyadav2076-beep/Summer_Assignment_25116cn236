#include <stdio.h>

long long getLargestPrimeFactor(long long n) {
    long long maxPrime = -1;

    while (n % 2 == 0) {
        maxPrime = 2;
        n /= 2; 
    }

    for (long long i = 3; i * i <= n; i += 2) {
        while (n % i == 0) {
            maxPrime = i;
            n /= i;
        }
    }

    if (n > 2) {
        maxPrime = n;
    }

    return maxPrime;
}

int main() {
    long long number;

    printf("Enter a positive integer: ");
    if (scanf("%lld", &number) != 1 || number <= 1) {
        printf("Please enter a valid integer greater than 1.\n");
        return 1;
    }

    long long result = getLargestPrimeFactor(number);
    printf("The largest prime factor of %lld is: %lld\n", number, result);

    return 0;
}
