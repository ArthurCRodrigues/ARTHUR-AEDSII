#include <stdio.h>
#include <string.h>

int main ( void ) { 
    char str[50];
    while (strcmp(str,"FIM\n") != 0) {
        fgets(str, sizeof str, stdin);
        printf("%s",str);
    }
    
}