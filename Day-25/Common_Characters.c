#include <stdio.h>
#include <string.h>

#define MAX_SIZE 256

int main() {
    char str1[MAX_SIZE];
    char str2[MAX_SIZE];
    
    int presentInStr1[256] = {0};
    int presentInStr2[256] = {0};
    int foundCommon = 0;

    printf("Enter the first string: ");
    fgets(str1, sizeof(str1), stdin);
    
    printf("Enter the second string: ");
    fgets(str2, sizeof(str2), stdin);

    for (int i = 0; str1[i] != '\0'; i++) {

        if (str1[i] != '\n') {
            presentInStr1[(unsigned char)str1[i]] = 1;
        }
    }

    for (int i = 0; str2[i] != '\0'; i++) {

        if (str2[i] != '\n') {
            presentInStr2[(unsigned char)str2[i]] = 1;
        }
    }

    printf("Common characters: ");
    for (int i = 0; i < 256; i++) {
        if (presentInStr1[i] == 1 && presentInStr2[i] == 1) {

            if (i == ' ') {
                printf("[Space] ");
            } else {
                printf("%c ", i);
            }
            foundCommon = 1;
        }
    }

    if (!foundCommon) {
        printf("None");
    }
    
    printf("\n");
    return 0;
}
