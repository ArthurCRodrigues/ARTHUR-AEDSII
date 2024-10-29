#include <stdio.h>
#include <stdbool.h>
#include <string.h>
#include <stdlib.h>
#include <time.h>

typedef struct Date {
    int day;
    int month;
    int year;
} Date;

char *dateToString(Date date) {
    char *str = (char *)malloc(11 * sizeof(char));
    if (str != NULL) {
        sprintf(str, "%02d/%02d/%04d", date.day, date.month, date.year);
    }
    return str;
}

Date stringToDate(char *str) {
    Date date = {0, 0, 0};
    if (str != NULL && strlen(str) > 0) {
        sscanf(str, "%d/%d/%d", &date.day, &date.month, &date.year);
    }
    return date;
}

typedef struct Pokemon {
    int id;
    int generation;
    char *name;
    char *description;
    char types[2][50];
    char abilities[6][50];
    double weight;
    double height;
    int captureRate;
    bool isLegendary;
    Date captureDate;
} Pokemon;

// strdup alternative function
char *my_strdup(const char *s) {
    char *copy = (char *)malloc(strlen(s) + 1);
    if (copy != NULL) {
        strcpy(copy, s);
    }
    return copy;
}

// id getter and setter
int getId(Pokemon *p) { return p->id; }
void setId(Pokemon *p, int id) { p->id = id; }

// generation getter and setter
int getGeneration(Pokemon *p) { return p->generation; }
void setGeneration(Pokemon *p, int generation) { p->generation = generation; }

// name getter and setter
char *getName(Pokemon *p) { return p->name; }
void setName(Pokemon *p, char *name) { p->name = name; }

// description getter and setter
char *getDescription(Pokemon *p) { return p->description; }
void setDescription(Pokemon *p, char *description) { p->description = description; }

// types getter and setter
char *getTypes(Pokemon *p, int index) { return p->types[index]; }
void setTypes(Pokemon *p, int index, char *type) {
    strncpy(p->types[index], type, sizeof(p->types[index]) - 1);
    p->types[index][sizeof(p->types[index]) - 1] = '\0';
}

// abilities getter and setter
char *getAbilities(Pokemon *p, int index) { return p->abilities[index]; }
void setAbilities(Pokemon *p, int index, const char *ability) {
    strncpy(p->abilities[index], ability, sizeof(p->abilities[index]) - 1);
    p->abilities[index][sizeof(p->abilities[index]) - 1] = '\0';
}

// weight and height getter and setter
double getWeight(Pokemon *p) { return p->weight; }
void setWeight(Pokemon *p, double weight) { p->weight = weight; }

double getHeight(Pokemon *p) { return p->height; }
void setHeight(Pokemon *p, double height) { p->height = height; }

// captureRate getter and setter
int getCaptureRate(Pokemon *p) { return p->captureRate; }
void setCaptureRate(Pokemon *p, int captureRate) { p->captureRate = captureRate; }

// isLegendary getter and setter
bool getIsLegendary(Pokemon *p) { return p->isLegendary; }
void setIsLegendary(Pokemon *p, bool isLegendary) { p->isLegendary = isLegendary; }

// captureDate getter and setter
Date getCaptureDate(Pokemon *p) { return p->captureDate; }
void setCaptureDate(Pokemon *p, Date captureDate) { p->captureDate = captureDate; }

// Creating a Pokemon
Pokemon createPokemon(int id, int generation, char *name, char *description, char *type1, char *type2, char *abilities[6], double weight, double height, int captureRate, bool isLegendary, Date captureDate) {
    Pokemon p;

    setId(&p, id);
    setGeneration(&p, generation);
    setName(&p, my_strdup(name));
    setDescription(&p, my_strdup(description));
    setTypes(&p, 0, type1);
    if (type2 != NULL) {
        setTypes(&p, 1, type2);
    }
    for (int i = 0; i < 6; i++) {
        if (abilities[i] != NULL) {
            setAbilities(&p, i, abilities[i]);
        } else {
            strcpy(p.abilities[i], "");
        }
    }
    setWeight(&p, weight);
    setHeight(&p, height);
    setCaptureRate(&p, captureRate);
    setIsLegendary(&p, isLegendary);
    setCaptureDate(&p, captureDate);

    return p;
}

// CSV parser
int split_csv_line(char *line, char **fields, int max_fields) {
    int field_count = 0;
    char *ptr = line;
    int in_quotes = 0;
    char *field_start = ptr;

    while (*ptr && field_count < max_fields) {
        if (*ptr == '"') {
            in_quotes = !in_quotes;
        } else if (*ptr == ',' && !in_quotes) {
            *ptr = '\0';
            fields[field_count++] = field_start;
            field_start = ptr + 1;
        }
        ptr++;
    }
    if (field_count < max_fields) {
        fields[field_count++] = field_start;
    }
    return field_count;
}

// Read Pokemon from CSV
void lerPokemon(FILE *file, Pokemon *pokedex, int *n) {
    char line[1024];

    fgets(line, sizeof(line), file);

    while (fgets(line, sizeof(line), file) != NULL) {
        line[strcspn(line, "\n")] = '\0';
        Pokemon p = {0};
        char *fields[12];
        int field_count = split_csv_line(line, fields, 12);

        p.id = atoi(fields[0]);
        p.generation = atoi(fields[1]);
        p.name = my_strdup(fields[2]);
        p.description = my_strdup(fields[3]);
        setTypes(&p, 0, fields[4]);
        if (strlen(fields[5]) > 0) {
            setTypes(&p, 1, fields[5]);
        }
        for (int i = 0; i < 6 && fields[6]; i++) {
            setAbilities(&p, i, strtok(fields[6], ","));
        }
        p.weight = atof(fields[7]);
        p.height = atof(fields[8]);
        p.captureRate = atoi(fields[9]);
        p.isLegendary = atoi(fields[10]);
        p.captureDate = stringToDate(fields[11]);

        pokedex[(*n)++] = p;
    }
}

void imprimirPokemon(Pokemon *p) {
    printf("[#%d -> %s: %s - ['", getId(p), getName(p), getDescription(p));
    if (strlen(getTypes(p, 0)) > 0) {
        printf("%s", getTypes(p, 0));
    }
    if (strlen(getTypes(p, 1)) > 0) {
        printf("', '%s", getTypes(p, 1));
    }
    printf("'] - ");
    printf("[");
    for (int i = 0; i < 6 && strlen(getAbilities(p, i)) > 0; i++) {
        if (i > 0) printf(", ");
        printf("'%s'", getAbilities(p, i));
    }
    printf("] - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n", getWeight(p), getHeight(p), getCaptureRate(p), getIsLegendary(p) ? "true" : "false", getGeneration(p), dateToString(getCaptureDate(p)));
}

// Main function
int main() {
    char *csvPath = "/tmp/pokemon.csv";
    clock_t start = clock();
    FILE *file = fopen(csvPath, "r");
    if (!file) {
        printf("Erro ao abrir o arquivo CSV.\n");
        return 1;
    }

    Pokemon pokedex[801];
    int n = 0;
    lerPokemon(file, pokedex, &n);
    fclose(file);

    char inputId[10];
    scanf("%s", inputId);

    Pokemon findPokemon[51];
    int comp = 0, j = 0;
    while (strcmp(inputId, "FIM") != 0) {
        int id = atoi(inputId);
        for (int i = 0; i < n; i++) {
            comp++;
            if (pokedex[i].id == id) {
                findPokemon[j++] = pokedex[i];
                break;
            }
        }
        scanf("%s", inputId);
    }

    // Sorting by name
    for (int i = 0; i < j; i++) {
        int menor = i;
        for (int k = i + 1; k < j; k++) {
            comp++;
            if (strcmp(findPokemon[menor].name, findPokemon[k].name) > 0) {
                menor = k;
            }
        }
        if (menor != i) {
            Pokemon aux = findPokemon[i];
            findPokemon[i] = findPokemon[menor];
            findPokemon[menor] = aux;
        }
    }

    // Binary search
    char name[50];
    scanf(" %[^\r\n]", name);
    while (strcmp(name, "FIM") != 0) {
        int inicio = 0, fim = j - 1;
        bool foundPokemon = false;
        while (inicio <= fim) {
            comp++;
            int meio = inicio + (fim - inicio) / 2;
            int cmp = strcmp(name, findPokemon[meio].name);
            if (cmp == 0) {
                foundPokemon = true;
                break;
            } else if (cmp < 0) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }
        printf("%s\n", foundPokemon ? "SIM" : "NAO");
        scanf(" %[^\r\n]", name);
    }

    clock_t end = clock();
    double executionTime = ((double)(end - start)) / CLOCKS_PER_SEC * 1000.0;

    // Writing to output file
    FILE *outputFile = fopen("844188_binario.txt", "w");
    if (!outputFile) {
        printf("Erro ao abrir o arquivo!\n");
        return 1;
    }
    fprintf(outputFile, "844188\t%.2f\t%d\n", executionTime, comp);
    fclose(outputFile);

    // Freeing allocated memory
    for (int i = 0; i < n; i++) {
        free(pokedex[i].name);
        free(pokedex[i].description);
    }

    return 0;
}
