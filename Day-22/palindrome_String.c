#include <stdio.h>
#include <string.h>
#include <stdbool.h>

void isPalindrome(char *str) {
 	
    int left = 0;
  
    int right = strlen(str) - 1;

    while (left < right) {
      
        if (str[left] != str[right]) {
            printf("\"%s\" is not palindrome.\n",
               str);
            return;
        }

        left++;
        right--;
    }

    printf("\"%s\" is palindrome.\n",
               str);
}

int main() {
	
  	isPalindrome("madam");
  	isPalindrome("hello");
  	return 0;
}