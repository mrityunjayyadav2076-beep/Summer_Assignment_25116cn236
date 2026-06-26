#include <stdio.h>
#include <ctype.h>

int main() {
    char lowerChar, upperChar;

    printf("Enter a lowercase character: ");
    scanf("%c", &lowerChar);

    upperChar = toupper(lowerChar);

    printf("The uppercase equivalent is: %c\n", upperChar);

    return 0;
}
