#include <stdio.h>
#include <ctype.h>

int main() {
    char sentence[1000];
    int count = 0;
    int in_word = 0;

    printf("Enter a sentence: ");
    
    if (fgets(sentence, sizeof(sentence), stdin) == NULL) {
        printf("Error reading input.\n");
        return 1;
    }

    for (int i = 0; sentence[i] != '\0'; i++) {

        if (isspace((unsigned char)sentence[i])) {
            in_word = 0; 
        }
        else if (in_word == 0) {
            in_word = 1; 
            count++;   
        }
    }
    printf("Total number of words: %d\n", count);

    return 0;
}
