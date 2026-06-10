#include <stdio.h>

int main() {
    int decimalNumber;
    int binaryArray[32]; 
    int i = 0;

    printf("Enter a decimal number: ");
    if (scanf("%d", &decimalNumber) != 1) {
        printf("Invalid input.\n");
        return 1;
    }

    if (decimalNumber == 0) {
        printf("Binary equivalent: 0\n");
        return 0;
    }

    while (decimalNumber > 0) {
        binaryArray[i] = decimalNumber % 2; 
        decimalNumber = decimalNumber / 2;  
        i++;                                 
    }

    printf("Binary equivalent: ");
    for (int j = i - 1; j >= 0; j--) {
        printf("%d", binaryArray[j]);
    }
    printf("\n");

    return 0;
}
