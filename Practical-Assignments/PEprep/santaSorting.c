#include <stdio.h>
#include <string.h>

int main ( void ) {
    char str[100][100];
    char temp[100];
    int n;
    scanf("%d",&n);
    for (int i = 0 ; i < n ; i++) {
        printf("input str");
        scanf("%s",&str[i]);
    }
    int well = 0;
    for (int i = 0; i < n ; i++) {
        if (str[i][0] == '+') {
            well++;
        }

    }
    printf("%d",well);
}