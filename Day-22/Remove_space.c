#include <stdio.h>
#include <string.h>

void removeSpaces(char *str) {
    int i = 0; 
    int j = 0; 

    while (str[i] != '\0') {
        if (str[i] != ' ') {
            str[j] = str[i];
            j++;
        }
        i++;
    }
    

    str[j] = '\0';
}

int main() {
    char str[100];

    printf("Enter a string with spaces: ");
    
    if (fgets(str, sizeof(str), stdin) != NULL) {
        
        str[strcspn(str, "\n")] = '\0';

        removeSpaces(str);

        printf("String after removing spaces: %s\n", str);
    }

    return 0;
}
