#include <stdio.h>

unsigned long long findFactorial(int n);

int main() {
    int num;
    unsigned long long factorial;

    printf("Enter a positive integer: ");
    if (scanf("%d", &num) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    if (num < 0) {
        printf("Error! Factorial of a negative number does not exist.\n");
    } else {
        factorial = findFactorial(num);
        printf("Factorial of %d = %llu\n", num, factorial);
    }

    return 0;
}

unsigned long long findFactorial(int n) {
    unsigned long long fact = 1;
    
    for (int i = 1; i <= n; i++) {
        fact *= i;
    }
    
    return fact;
}
