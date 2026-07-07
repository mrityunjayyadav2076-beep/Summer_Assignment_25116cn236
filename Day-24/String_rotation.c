#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int check_rotation(char *str1, char *str2) {
    int len1 = strlen(str1);
    int len2 = strlen(str2);
    if (len1 != len2) {
        return 0;
    }


    char *temp = (char *)malloc(sizeof(char) * (len1 * 2 + 1));
    if (temp == NULL) {
        printf("Memory allocation failed.\n");
        return 0;
    }

    strcpy(temp, str1);
    strcat(temp, str1);
  
    char *match = strstr(temp, str2);

    free(temp);

    if (match != NULL) {
        return 1;
    } else {
        return 0;
    }
}

int main() {
    char str1[100];
    char str2[100];


    printf("Enter the first string: ");
    scanf("%99s", str1);

    printf("Enter the second string: ");
    scanf("%99s", str2);

    if (check_rotation(str1, str2)) {
        printf("Result: The strings are rotations of each other.\n");
    } else {
        printf("Result: The strings are NOT rotations of each other.\n");
    }

    return 0;
}
