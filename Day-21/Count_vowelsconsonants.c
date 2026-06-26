#include <stdio.h>   
#include <string.h>  

int main() {
    
    char str[100];  
    
    int vowels = 0, consonants = 0;  

    printf("Enter a string: ");
     
    gets(str);  

    for (int i = 0; i < strlen(str); i++) {

        if ((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z')) {

            if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u' ||
                str[i] == 'A' || str[i] == 'E' || str[i] == 'I' || str[i] == 'O' || str[i] == 'U') {

                vowels++; 

            } else {
                
                consonants++;  
            }
        }
    }

    printf("Vowels: %d\nConsonants: %d\n", vowels, consonants);

    return 0;
}