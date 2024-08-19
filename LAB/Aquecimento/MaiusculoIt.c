#include <stdio.h>
#include <string.h>
#include <ctype.h>
int countS(char *str) {
    int count = 0;
    for ( int i = 0 ; i < strlen(str); i++) {
        if (str[i]>='A' && str[i]<='Z') {
            count++;
        }
    }
    return count;
}

int main ( void ) {
    char txt[100];
    do {
        if (fgets(txt,sizeof(txt),stdin) != NULL) {
                if (txt[0] != '\n') {
                if (strcmp(txt,"FIM\n") == 0) break;
                printf("%d\n",countS(txt));
                }
            }

    } while (strcmp(txt,"FIM\n") != 0);
}
