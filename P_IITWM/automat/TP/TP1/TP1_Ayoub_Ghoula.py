""" TP1 EX 1 : Modélisation d’un automate"""
print("EX: 1 --------------------------------------------------------------------------------------------")
Max_Etats = 20
Max_Symboles = 10

# A = {
# "nbEtats": 0,
# "nbSymboles": 0,
# "symboles": [],
# "transitions": [[[0] * Max_Etats for _ in range(Max_Symboles)] for _ in range(Max_Etats)],
# "etatInitial": 0,
# "etatsFinaux": [0] * Max_Etats,
# }   

def initialiser():
    A={}
    A["nbEtats"] = 0
    A["nbSymboles"] = 0 
    A["symboles"] = []
    A["etatInitial"] = 0
    A["etatsFinaux"] = [0] * Max_Etats
    A["transitions"] = [[[0]*Max_Etats for j in range(Max_Symboles)] for i in range(Max_Etats)]
    return A

def ajouterTransition(A, etatSource, symbole, etatDest):
    if symbole not in A["symboles"]:
        A["symboles"].append(symbole)
        A["nbSymboles"] += 1
    if etatSource >= A["nbEtats"]:
        A["nbEtats"] = etatSource + 1
    if etatDest >= A["nbEtats"]:
        A["nbEtats"] = etatDest + 1
    indexSymbole = A["symboles"].index(symbole)
    if not A["transitions"][etatSource][indexSymbole][etatDest]:
        A["transitions"][etatSource][indexSymbole][etatDest] = 1
    return A

def afficherAutomate(A):
   print("Nm etats:",A["nbEtats"])
   print("Nb symboles:",A["nbSymboles"])
   print("Symboles:",A["symboles"])
   print("Etat initial:",A["etatInitial"])
   print("Etats finaux:",[i for i in range(A["nbEtats"]) if A["etatsFinaux"][i]==1])
   print("Transitions:")
   for i in range(A["nbEtats"]):
       for j in range(A["nbSymboles"]):
        destinations = []
        for k, present in enumerate(A["transitions"][i][j]): # mme resultat de cette for k est le index et present est la valeur si valeur est 0 n est pas add to destinations si 1 est ajouter 
            if present:
                destinations.append(k)
        if destinations:
            for destination in destinations:
                print(i,"--",A["symboles"][j],"-->",destination)




def etatFinal(A, etat):
    if etat >= A["nbEtats"]:
        A["nbEtats"] = etat + 1
    A["etatsFinaux"][etat] = 1
    return A


def etatInitial(A, etat):
    if etat >= A["nbEtats"]:
        A["nbEtats"] = etat + 1
    A["etatInitial"] = etat
    return A


A=initialiser()

A =etatFinal(A, 2)
A =etatFinal(A, 1)
A =etatInitial(A, 0)

A = ajouterTransition(A, 0, '0', 0)
A = ajouterTransition(A, 0, '0', 1)

A= ajouterTransition(A, 1, '0', 1)
A = ajouterTransition(A, 0, '1', 2)
A = ajouterTransition(A, 2, '1', 2)
A = ajouterTransition(A, 2, '1', 0)
A = ajouterTransition(A, 0, '1', 2)


# A= ajouterTransition(A, 0, 'a', 0)
# A= ajouterTransition(A, 0, 'b', 0)
# A= ajouterTransition(A, 0, 'a', 1)
# A= ajouterTransition(A, 1, 'b', 2)

# A= ajouterTransition(A, 0, 'b', 1)
# A= ajouterTransition(A, 1, 'a', 2)
# A= ajouterTransition(A, 1, 'a', 1)
# A= ajouterTransition(A, 1, 'b', 2)
# A= ajouterTransition(A, 2, 'a', 0)



afficherAutomate(A)



"""

resultat dans la terminal:

Nm etats: 6
Nb symboles: 3
Symboles: ['a', 'b', 'c']
Etat initial: 0
Etats finaux: [2, 5]
Transitions:
0 -- a --> 1
0 -- b --> 2
1 -- b --> 2
2 -- c --> 1
3 -- a --> 2
3 -- c --> 1


"""



"""Exercice 2 : Détermination d'un automate non déterministe"""

print("EX: 2 --------------------------------------------------------------------------------------------")
def find_set_index(list_of_sets, target_set):
    for i, s in enumerate(list_of_sets):
        if s == target_set:
            return i
    return -1




def notdet_to_det (A):
    etats = []
    def etat_posible(start, current):
        if current:
            etats.append(set(current))
        for i in range(start, A["nbEtats"]):
            etat_posible(i + 1, current + [i])
    etat_posible(0, [])
    dict_etats = [[{}, 0, 0] for _ in range(len(etats))]
    for i in range(len(etats)):
         for symbole in A["symboles"]:
            distination = set()
            indexSymbole = A["symboles"].index(symbole)
            for j in etats[i]:
                translaction = A["transitions"][j][indexSymbole]
                for k, present in enumerate(translaction):
                    if present:
                        distination.add(k)

            if not distination:
                dict_etats[i][0][symbole] = None
                continue
            dict_etats[i][0][symbole] = distination
            dict_etats[i][1] += 1
            destination_index = find_set_index(etats, distination)
            if destination_index != -1:
                
                dict_etats[destination_index][2] += 1
    the_importent=[]
    etats_importants = []
    for index ,valeur in enumerate(dict_etats):
        if valeur[2]>0 or etats[index] == set([A["etatInitial"]]):
            the_importent.append(valeur)
            etats_importants.append(etats[index])
    B=initialiser()
    for i in range(len(the_importent)):
        for symbole, distination in the_importent[i][0].items():
            if distination is not None:
                destination_index = find_set_index(etats_importants, distination)
                if destination_index != -1:
                    B = ajouterTransition(B, i, symbole, destination_index)
            if any(A["etatsFinaux"][x] == 1 for x in etats_importants[i]):
                B = etatFinal(B, i)
    return B

B=notdet_to_det(A)
afficherAutomate(B)


"""
resultat dans la terminal:
Nm etats: 3
Nb symboles: 2
Symboles: ['a', 'b']
Etat initial: 0
Etats finaux: [2]
Transitions:
0 -- a --> 1
1 -- a --> 1
1 -- b --> 2
"""