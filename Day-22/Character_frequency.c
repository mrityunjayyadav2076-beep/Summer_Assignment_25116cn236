#include <stdio.h>
#include <string.h>

#define MAX_SIZE 1000

int main() {
    char str[MAX_SIZE];
    int freq[256] = {0};
    int i;

    printf("Enter a string: ");
    if (fgets(str, sizeof(str), stdin) != NULL) {
        
        str[strcspn(str, "\n")] = '\0';

        for (i = 0; str[i] != '\0'; i++) {
            freq[(unsigned char)str[i]]++;
        }


        printf("\nCharacter frequencies:\n");
        for (i = 0; i < 256; i++) {
            if (freq[i] != 0) {
                printf("'%c' : %d\n", i, freq[i]);
            }
        }
    }

    return 0;
}
