#include <stdio.h>
#include <string.h>



int palRec(char *word , int tail) {
    int length = strlen(word) - 1;
    int indx = length - tail;
    if (indx < 1) {
        return 0;
    }
    if (word[0] != word[indx]) {
        return 1;
    }
    else {
        return palRec(&word[1],tail+1);
    }
}
int palindromeRecursive( char *word) {
    return palRec(word,1);
}


int main ( void ) { 
    char str[255];

    while (strcmp(str,"FIM\n") != 0) {
        fgets(str,sizeof(str),stdin);
        if (palindromeRecursive(str) == 0) {
            printf("SIM\n");
        }
        else {
            printf("NAO\n");
        }
    }
    
}