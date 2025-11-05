
#include <stdio.h>

#define MAX_ETATS 20 
#define MAX_SYMBOLES 20

typedef struct {
    int nbEtats;
    int nbSymboles;
    int transition[MAX_ETATS][MAX_SYMBOLES];
    int etatInitial;
    int etatsFinaux[MAX_ETATS];
    int nbFinaux;
} Automate;


void initialiser(Automate *afd) {
    printf("Nombre d'états : ");
    scanf("%d", &afd->nbEtats);
    printf("Nombre de symboles (ex: 2 pour {a,b}) : ");
    scanf("%d", &afd->nbSymboles);

    printf("État initial : ");
    scanf("%d", &afd->etatInitial);

    printf("Nombre d'états finaux : ");
    scanf("%d", &afd->nbFinaux);
    printf("États finaux : ");
    for (int i = 0; i < afd->nbFinaux; i++)
        scanf("%d", &afd->etatsFinaux[i]);

    printf("Table de transitions :\n");
    for (int i = 0; i < afd->nbEtats; i++) {
        for (int j = 0; j < afd->nbSymboles; j++) {
            printf("δ(%d, %c) = ", i, 'a' + j);
            scanf("%d", &afd->transition[i][j]);
        }
    }
}






int main() {
    Automate afd;
    initialiser(&afd);

    return 0;
}