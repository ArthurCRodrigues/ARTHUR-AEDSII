#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_ENTITIES 1000
#define MAX_LINE_SIZE 256
#define MAX_ENTITY_TYPES 2
#define MAX_SKILLS 10

typedef struct {
    int identifier;
    int gen;
    char entityName[50];
    char entityDescription[256];
    char entityTypes[MAX_ENTITY_TYPES][50];
    char skills[MAX_SKILLS][50];
    double mass;
    double size;
    int catchRate;
    bool legendaryFlag;
    struct tm dateCaptured;
} Entity;

void showEntity(Entity e) {
    char captureDateStr[11];
    strftime(captureDateStr, sizeof(captureDateStr), "%d/%m/%Y", &e.dateCaptured);

    printf("[#%d -> %s: %s - [", e.identifier, e.entityName, e.entityDescription);
    for (int i = 0; i < MAX_ENTITY_TYPES && strlen(e.entityTypes[i]) > 0; i++) {
        printf("'%s'", e.entityTypes[i]);
        if (i < MAX_ENTITY_TYPES - 1 && strlen(e.entityTypes[i + 1]) > 0) {
            printf(", ");
        }
    }
    printf("] - [");
    for (int i = 0; i < MAX_SKILLS && strlen(e.skills[i]) > 0; i++) {
        printf("'%s'", e.skills[i]);
        if (i < MAX_SKILLS - 1 && strlen(e.skills[i + 1]) > 0) {
            printf(", ");
        }
    }
    printf("] - %.1fkg - %.1fm - %d%% - %s - %d gen] - %s\n",
           e.mass, e.size, e.catchRate, e.legendaryFlag ? "true" : "false", e.gen, captureDateStr);
}

void trimSpaces(char *str) {
    char *end;

    // Remove spaces from the beginning
    while(isspace((unsigned char)*str)) str++;

    // Remove spaces from the end
    end = str + strlen(str) - 1;
    while(end > str && isspace((unsigned char)*end)) end--;
    end[1] = '\0';
}

Entity readEntity(char *line) {
    Entity e;
    char *token;
    char *remaining = line;
    int field = 0;

    while ((token = strtok_r(remaining, ",", &remaining))) {
        trimSpaces(token); // Clean up spaces around the token

        switch (field) {
            case 0: e.identifier = atoi(token); break;
            case 1: e.gen = atoi(token); break;
            case 2: strcpy(e.entityName, token); break;
            case 3: strcpy(e.entityDescription, token); break;
            case 4: 
                strcpy(e.entityTypes[0], token); 
                break;
            case 5: 
                strcpy(e.entityTypes[1], token); 
                break;
            case 6: {
                char *skillToken;
                char *remainingSkills = token;
                int skillIndex = 0;
                while ((skillToken = strtok_r(remainingSkills, "[]'\"", &remainingSkills))) {
                    trimSpaces(skillToken); // Clean up spaces around the skill
                    if (strlen(skillToken) > 0) {
                        strcpy(e.skills[skillIndex++], skillToken);
                    }
                }
                break;
            }
            case 7: e.mass = atof(token); break;
            case 8: e.size = atof(token); break;
            case 9: e.catchRate = atoi(token); break;
            case 10: e.legendaryFlag = strcmp(token, "1") == 0; break;
            //case 11: strptime(token, "%d/%m/%Y", &e.dateCaptured); break;
        }
        field++;
    }

    // Initialize types and skills that were not filled
    for (int i = field; i < MAX_ENTITY_TYPES; i++) {
        e.entityTypes[i][0] = '\0';
    }
    for (int i = field; i < MAX_SKILLS; i++) {
        e.skills[i][0] = '\0';
    }

    return e;
}

// Comparison function to sort the entities by their names
int compareEntitiesByName(const void *a, const void *b) {
    Entity *entityA = (Entity *)a;
    Entity *entityB = (Entity *)b;
    return strcmp(entityA->entityName, entityB->entityName);
}

int main() {
    FILE *file = fopen("/tmp/creatures.csv", "r");
    if (!file) {
        perror("Error opening file");
        return 1;
    }

    char line[MAX_LINE_SIZE];
    Entity entities[MAX_ENTITIES];
    int totalEntities = 0;

    // Skip the first line (header)
    if (fgets(line, sizeof(line), file)) {
        // Skip header
    }

    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = 0; // Remove the newline character
        if (strcmp(line, "FIM") == 0) {
            break;
        }

        entities[totalEntities++] = readEntity(line);
    }

    fclose(file);

    // Phase 1: Accept IDs until 'FIM'
    int selectedEntityIds[MAX_ENTITIES];
    int totalSelected = 0;
    int searchedId;

    while (scanf("%d", &searchedId) == 1) {
        if (searchedId == -1) {  // Assuming -1 means FIM for the ID inputs
            break;
        }
        bool found = false;
        for (int i = 0; i < totalEntities; i++) {
            if (entities[i].identifier == searchedId) {
                selectedEntityIds[totalSelected++] = i;
                found = true;
                break;
            }
        }
        if (!found) {
            printf("Entity with ID %d not found.\n", searchedId);
        }
    }

    // Sort selected entities by name
    qsort(entities, totalSelected, sizeof(Entity), compareEntitiesByName);

    // Phase 2: Read Pokémon names and check if they are in the selected entities
    char nameInput[50];
    while (scanf("%s", nameInput) == 1) {
        if (strcmp(nameInput, "FIM") == 0) {
            break;
        }
        bool found = false;
        for (int i = 0; i < totalSelected; i++) {
            if (strcmp(entities[selectedEntityIds[i]].entityName, nameInput) == 0) {
                printf("SIM\n");
                found = true;
                break;
            }
        }
        if (!found) {
            printf("NAO\n");
        }
    }

    return 0;
}
