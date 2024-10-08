#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

char getRandomChar() {
    return 'a' + (rand() % 26);
}

void randomSwitch(char *wrd, char char1, char char2, int index) {

    if (index == strlen(wrd)) {
        return;
    }


    if (wrd[index] == char1) {
        wrd[index] = char2;
    }
    printf("\nCHAR1 -> %c\nCHAR2 -> %c \n",char1,char2);

    randomSwitch(wrd, char1, char2, index + 1);
}

int main() {
    srand(4); 
    
    char wrd[100];
    fgets(wrd,sizeof(wrd),stdin);

    while (strcmp(wrd, "FIM") != 0) {
        char char1 = getRandomChar();
        char char2;


        do {
            char2 = getRandomChar();
        } while (char1 == char2);


        randomSwitch(wrd, char1, char2, 0);

        printf("%s", wrd);

        fgets(wrd,sizeof(wrd),stdin);
    }

    return 0;
}
