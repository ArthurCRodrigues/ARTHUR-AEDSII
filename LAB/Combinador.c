#include <stdio.h>
#include <string.h>
void combinador( char *str1, char *str2) {
        char *maior;
        char *menor;
        int caso = 0;
        if (strlen(str1) > strlen(str2)){
         maior = str1;
         menor = str2;
         caso = 1;
        }
        else {
         maior = str2;
         menor = str1;
        }
        if (caso == 1) {

        for (int i = 0 ; i < strlen(maior) ; i++) {
                if (i < strlen(menor)) printf("%c",menor[i]);
                printf("%c",maior[i]);          
        }

        }
        else {
        for (int i = 0 ; i < strlen(maior) ; i++) {
                printf("%c",maior[i]);          
                if (i < strlen(menor)) printf("%c",menor[i]);   
        } 
}
}


int main ( void ) {
  char pal1[50];
  char pal2[50];
  while (scanf("%s %s",pal1,pal2) != EOF) {
        combinador(pal2,pal1);
        printf("\n");
}

}

