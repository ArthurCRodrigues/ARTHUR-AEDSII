#include <stdio.h>
#include <string.h>

void palindrome(char *nome) {
    int fst;
    int lst = strlen(nome) -2;
    int pal = 0;
    for ( fst = 0 ; fst <= lst ; fst++) {
        if (nome[fst] != nome[lst]) {
            pal = 1;
        }
        lst--;
    }
    if (pal == 1) {
        printf("NAO\n");
    }
    else {
        printf("SIM\n");
    }

    }
int main ( void ) {
    char nome[50];
    do {
      fgets(nome,sizeof(nome),stdin);
      if (strcmp(nome,"FIM\n") == 0) {
        break;
      }
      palindrome(nome);
    }while (strcmp(nome,"FIM\n") != 0);



    return 0;
}
