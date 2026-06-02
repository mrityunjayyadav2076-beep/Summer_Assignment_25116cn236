#include <stdio.h>

int main() {
    int num, original, reverse = 0, digit;

    printf("Enter a number: ");
    scanf("%d", &num);

    original = num;

    while(num != 0) {
        digit = num % 10;
        reverse = reverse * 10 + digit;
        num = num / 10;
    }

    if(original == reverse)
        printf("%d is a Palindrome Number.\n", original);
    else
        printf("%d is not a Palindrome Number.\n", original);

    return 0;
}