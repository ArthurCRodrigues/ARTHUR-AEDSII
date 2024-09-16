#include <stdio.h>
#include <string.h>

int main(void) {
    char str[100][100];
    char temp[100];
    int n;
    scanf("%d", &n);
    while (getchar() != '\n');  

    for (int i = 0; i < n; i++) {
        fgets(str[i], sizeof(str[i]), stdin);
        str[i][strcspn(str[i], "\n")] = 0;  
    }

    int well = 0;
    for (int i = 0; i < n; i++) {
        if (str[i][0] == '+') {
            well++;
        }
    }

    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            // Compare strings starting from index 1
            if (strcmp(str[j] + 1, str[j + 1] + 1) > 0) {
                // Swap strings
                strcpy(temp, str[j]);
                strcpy(str[j], str[j + 1]);
                strcpy(str[j + 1], temp);
            }
        }
    }

   
    printf("%d\n", well);

    for (int i = 0; i < n; i++) {
        printf("%s\n", str[i] + 1); 
    }

    return 0;
}
