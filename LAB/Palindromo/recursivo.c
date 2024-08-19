#include <stdio.h>
#include <string.h>

int num = 0;

int palindrome_private( char *word, int lst) {
    num++;
    int fst = 0;
    if(strlen(word) == 1) {
        return 0;
    }
    else if (word[fst] != word[lst]) {
        return 1;
    }
    else if (word[fst] == word[lst]) {
        return palindrome_private(&word[1],lst-2);
    }
}

int palindrome(char *word) {
    return palindrome_private(word,strlen(word) - 2);
}




int main ( void ) {
    char word[100];
    printf("Input word: ");
    fgets(word,sizeof(word),stdin);
    if (palindrome(word) == 0 ) printf("Palindrome!");
    else printf("Not!");
    printf("\nNUM OF EXECUTIONS: %d",num);


}
