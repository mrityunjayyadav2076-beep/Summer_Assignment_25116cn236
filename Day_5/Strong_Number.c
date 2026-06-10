#include <stdio.h>

long long calculateFactorial(int digit) {
    long long fact = 1;
    for (int i = 1; i <= digit; i++) {
        fact *= i;
    }
    return fact;
}

int main() {
    int number, originalNumber, remainder;
    long long sum = 0;

    printf("Enter an integer to check: ");
    if (scanf("%d", &number) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    originalNumber = number;

    if (number < 0) {
        printf("%d is not a strong number.\n", number);
        return 0;
    }

    while (number > 0) {
        remainder = number % 10;                
        sum += calculateFactorial(remainder);   
        number = number / 10;                   
    }
    
    if (sum == originalNumber) {
        printf("%d is a strong number.\n", originalNumber);
    } else {
        printf("%d is not a strong number.\n", originalNumber);
    }

    return 0;
}
