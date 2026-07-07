#include <stdio.h>

#include <string.h>

int main() {

char sentence[100];

printf("Enter a sentence: ");

fgets(sentence, sizeof(sentence), stdin);

char largest_word[100];

int i, len, largest_len = 0;


char *word = strtok(sentence, " ");

while (word != NULL) {

len = strlen(word);

if (len > largest_len) {

largest_len = len;

strcpy(largest_word, word);

}

word = strtok(NULL, " ");

}

printf("Largest word: %s", largest_word);

return 0;

}