#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
    int alf, msg;
    scanf("%d %d", &alf, &msg);
    while (getchar() != '\n'); 

    printf("ALF -> %d\nMSG -> %d\n", alf, msg);

    char alfa[100];
    fgets(alfa, sizeof(alfa), stdin);
    alfa[strcspn(alfa, "\n")] = 0;  

    char msge[100];
    fgets(msge, sizeof(msge), stdin);
    msge[strcspn(msge, "\n")] = 0;  

    int isAlien = 0;
    int msglen = strlen(msge);
    int alfalen = strlen(alfa);

    // Check if all characters in msge are in alfa
    for (int i = 0; i < msglen; i++) {
        int found = 0;
        for (int j = 0; j < alfalen; j++) {
            if (msge[i] == alfa[j]) {
                found = 1;
                break;
            }
        }
        if (!found) {
            isAlien = 1;
            break;
        }
    }

    printf("%d\n", isAlien);

    return 0;
}
