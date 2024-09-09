#include <stdio.h>
#include <stdlib.h>

int main() {
    FILE *file;
    int n, number;

    // Abre o arquivo em modo de leitura e escrita binária ("wb+" = write binary/read binary)
    file = fopen("integers.txt", "wb+");
    if (file == NULL) {
        return 1;
    }

    // Lê a quantidade de números que o usuário vai inserir
    scanf("%d", &n);

    // Escreve os números no arquivo
    for (int i = 0; i < n; i++) {
        scanf("%d", &number);
        fwrite(&number, sizeof(int), 1, file);  // Escreve o número no arquivo
    }

    // Calcula o número de inteiros no arquivo
    fseek(file, 0, SEEK_END);  // Move o ponteiro para o final do arquivo
    long fileSize = ftell(file);  // Obtém o tamanho total do arquivo em bytes
    int numIntegers = fileSize / sizeof(int);  // Calcula o número total de inteiros

    // Lê os números do arquivo em ordem reversa
    for (int i = numIntegers - 1; i >= 0; i--) {
        fseek(file, i * sizeof(int), SEEK_SET);  // Move o ponteiro para o i-ésimo número
        fread(&number, sizeof(int), 1, file);    // Lê o número do arquivo
        printf("%d\n", number);                  // Imprime o número
    }

    // Fecha o arquivo
    fclose(file);

    return 0;
}
