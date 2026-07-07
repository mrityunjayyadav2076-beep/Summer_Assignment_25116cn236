#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#define MAX_SIZE 256

void removeDuplicates(char *str) {

    bool seen[MAX_SIZE] = { false };
    
    int readIndex = 0;
    int writeIndex = 0;


    while (str[readIndex] != '\0') {

        unsigned char ch = str[readIndex];


        if (!seen[ch]) {
            seen[ch] = true;
            str[writeIndex] = str[readIndex];
            writeIndex++;
        }
        readIndex++;
    }
    

    str[writeIndex] = '\0';
}

int main() {
    char str[1000];

    printf("Enter a string: ");
    

    if (fgets(str, sizeof(str), stdin) != NULL) {
        
        str[strcspn(str, "\n")] = '\0';

        removeDuplicates(str);

        printf("String after removing duplicates: %s\n", str);
    }

    return 0;
}
