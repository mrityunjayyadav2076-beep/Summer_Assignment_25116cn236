#include <stdio.h>

int main() {
    int num, digit;
    long long product = 1;

    printf("Enter a number: ");
    scanf("%d", &num);

    while(num != 0) {
        digit = num % 10;
        product = product * digit;
        num = num / 10;
    }

    printf("Product of digits = %lld\n", product);

    return 0;
}