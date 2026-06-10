#include <stdio.h>

unsigned long long factorial(unsigned int n);

int main() {
    unsigned int num;
    unsigned long long result;

    printf("Enter a positive integer: ");
    if (scanf("%u", &num) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    result = factorial(num);

    printf("Factorial of %u = %llu\n", num, result);

    return 0;
}

unsigned long long factorial(unsigned int n) {
    if (n <= 1) {
        return 1;
    }
    return n * factorial(n - 1);
}
