#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main ( void ) {
    srand(4);
    int i = 0;
    char char1 = 'a' + (abs(rand()) % 26);
    char char2;
    do {
        char char2 = 'a' + (abs(rand()) % 26);
    } while (char1 == char2);
    printf("%c\t%c",char1,char2);
    

}