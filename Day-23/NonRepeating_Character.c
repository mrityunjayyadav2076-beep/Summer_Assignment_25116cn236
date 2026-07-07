#include <stdio.h>
#include <string.h>

#define MAX_SIZE 100
#define ASCII_SIZE 256

int main() {
    char str[MAX_SIZE];
    int freq[ASCII_SIZE] = {0};
    char result = '\0';
    printf("Enter a string: ");
    if (fgets(str, sizeof(str), stdin) == NULL) {
        printf("Error reading input.\n");
        return 1;
    }

    str[strcspn(str, "\n")] = '\0';

    for (int i = 0; str[i] != '\0'; i++) {
        freq[(unsigned char)str[i]]++;
    }

    for (int i = 0; str[i] != '\0'; i++) {
        if (freq[(unsigned char)str[i]] == 1) {
            result = str[i];
            break; 
        }
    }

    if (result != '\0') {
        printf("The first non-repeating character is: '%c'\n", result);
    } else {
        printf("All characters repeat or the string is empty.\n");
    }

    return 0;
}
