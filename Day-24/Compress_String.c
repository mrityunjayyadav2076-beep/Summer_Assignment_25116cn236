#include <stdio.h>
#include <string.h>

void compressString(char *src, char *dest) {
    int i = 0;
    int j = 0;
    int len = strlen(src);

    while (i < len) {
 
        dest[j++] = src[i];


        int count = 1;
        while (i + 1 < len && src[i] == src[i + 1]) {
            count++;
            i++;
        }


        char countStr[20];
        sprintf(countStr, "%d", count);
        for (int k = 0; countStr[k] != '\0'; k++) {
            dest[j++] = countStr[k];
        }

        i++;
    }
    
    dest[j] = '\0'; 
}

int main() {
    char input[500];
    char compressed[1000]; 

    printf("Enter a string to compress: ");
    
 
    scanf("%499[^\n]", input);

    compressString(input, compressed);

    printf("Original String: %s\n", input);
    printf("Compressed String: %s\n", compressed);

    return 0;
}
