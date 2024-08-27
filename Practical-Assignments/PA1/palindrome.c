#include <stdio.h>
#include <string.h>

void palindrome(char *word) {
    int lst = strlen(word) - 1;
    for (int i = 0; i < strlen(word); i++) {
        if (word[i] != word[lst]) {
            printf("NAO\n");
            return;
        }
        lst--;
    }
    printf("SIM\n");
    return;
}

int main() {
    char word[100];
    int keep_running = 1;

    while (keep_running) {
        fgets(word, 100, stdin);
        // Remove newline character
        word[strcspn(word, "\n")] = '\0';

        // Check if the input is "FIM"
        keep_running = strcmp(word, "FIM") != 0;

        if (keep_running) {
            palindrome(word);
        }
    }

    return 0;
}
