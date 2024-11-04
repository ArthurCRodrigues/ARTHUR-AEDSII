#include <stdio.h>
#include <string.h>

void sortWordsByLength(char *sentence) {
    char *words[100];
    int lengths[100];
    int count = 0;

    char *word = strtok(sentence, " ");
    while (word != NULL) {
        words[count] = word;
        lengths[count] = strlen(word);
        count++;
        word = strtok(NULL, " ");
    }

    // Sort words by length using bubble sort
    for (int i = 0; i < count - 1; i++) {
        for (int j = 0; j < count - 1 - i; j++) {
            if (lengths[j] < lengths[j + 1]) {
                int tempLen = lengths[j];
                lengths[j] = lengths[j + 1];
                lengths[j + 1] = tempLen;

                char *tempWord = words[j];
                words[j] = words[j + 1];
                words[j + 1] = tempWord;
            }
        }
    }

    for (int i = 0; i < count; i++) {
        printf("%s ", words[i]);
    }
    printf("\n");
}

int main(void) {
    int palavras;
    scanf("%d", &palavras);
    char sentence[1000];

    for (int i = 0; i < palavras; i++) {
        scanf(" %[^\n]", sentence);
        sortWordsByLength(sentence);
    }

    return 0;
}