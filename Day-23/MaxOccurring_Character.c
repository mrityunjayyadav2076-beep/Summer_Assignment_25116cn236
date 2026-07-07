#include <stdio.h>
#include <string.h>

#define MAX_SIZE 100 
#define ASCII_SIZE 256 

int main() {
    char str[MAX_SIZE];
    int freq[ASCII_SIZE] = {0}; 
    int i, max_idx;

    printf("Enter a string: ");
    fgets(str, sizeof(str), stdin);

    str[strcspn(str, "\n")] = '\0';

    for (i = 0; str[i] != '\0'; i++) {
        unsigned char ch = str[i];
        freq[ch]++;
    }

    max_idx = 0;
    for (i = 0; i < ASCII_SIZE; i++) {
        if (freq[i] > freq[max_idx]) {
            max_idx = i;
        }
    }

    if (freq[max_idx] > 0) {
        printf("The maximum occurring character is '%c' with a frequency of %d.\n", max_idx, freq[max_idx]);
    } else {
        printf("The string is empty.\n");
    }

    return 0;
}
