#include <stdio.h>
#include <math.h>
#include <stdbool.h>

bool isArmstrong(int num);

int main() {
    int number;

    printf("Enter an integer: ");
    if (scanf("%d", &number) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    if (isArmstrong(number)) {
        printf("%d is an Armstrong number.\n", number);
    } else {
        printf("%d is not an Armstrong number.\n", number);
    }

    return 0;
}

bool isArmstrong(int num) {
    int temp = num;
    int digits = 0;
    int sum = 0;

    while (temp != 0) {
        digits++;
        temp /= 10;
    }

    temp = num;

    while (temp != 0) {
        int remainder = temp % 10;
        
        sum += (int)round(pow(remainder, digits)); 
        
        temp /= 10;
    }

    return (sum == num);
}
