#include <stdio.h>
#include <string.h>
typedef struct {
    char *nome;
    int times;
} arvore;

arvore create_arvore(char *nome) {
    arvore a;
    a.nome = nome;
    a.times = 1;
    return a;
}
int main ( void ) {
    int num_tests;
    scanf("%d",&num_tests);
    for (int i = 0 ; i< num_tests; i++) {
        char *str;
        arvore trees[1000];
        int aux = 0;
        int sec = 0;
        while (scanf("%s",str) != EOF) {
            for (int i = 0 ; trees[i].nome != NULL; i++) {
                if (strcmp(trees[i].nome,str) == 0) {
                    trees[i].times++;
                    sec = 1;
                }
            }
            if (sec == 0) { 
                arvore tree = create_arvore(str);
                trees[aux] = tree;
                aux++;
            }
            
        }
        aux++;
        int var = 0;
        while (trees[var].nome != NULL) {
            printf("%s %2.f",trees[var].nome, aux/trees[var].times);
            var++;
        }
    }
}