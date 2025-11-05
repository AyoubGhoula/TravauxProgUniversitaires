from graphviz import Digraph


MAX_ETATS = 20
MAX_SYMBOLES = 20

class Automate:
    def __init__(self):
        self.nbEtats = 0
        self.nbSymboles = 0
        self.transition = [[0 for _ in range(MAX_SYMBOLES)] for _ in range(MAX_ETATS)]
        self.etatInitial = 0
        self.etatsFinaux = [-1] * MAX_ETATS
        self.nbFinaux = 0 




def initialiser(afd):
    afd.nbEtats = int(input("Nombre d'états : "))
    afd.nbSymboles = int(input("Nombre de symboles (ex: 2 pour {a,b}) : "))

    afd.etatInitial = int(input("État initial : "))

    afd.nbFinaux = int(input("Nombre d'états finaux : "))
    print("États finaux : ", end="")
    for i in range(afd.nbFinaux):
        afd.etatsFinaux[i] = int(input())

    print("Table de transitions :")
    for i in range(afd.nbEtats):
        for j in range(afd.nbSymboles):
            symbole = chr(ord('a') + j)
            afd.transition[i][j] = int(input(f"δ({i}, {symbole}) = "))

def afichage(afd):
    print(f"États : 0 à {afd.nbEtats - 1}")
    print(f"Alphabet : {{ {', '.join(chr(ord('a') + j) for j in range(afd.nbSymboles))} }}")
    print(f"État initial : {afd.etatInitial}")
    print(f"États finaux : {afd.etatsFinaux[:afd.nbFinaux]}")
    print("Transitions :")
    for i in range(afd.nbEtats):
        for j in range(afd.nbSymboles):
            print(f"  δ({i}, {chr(ord('a') + j)}) = {afd.transition[i][j]}")

def min_afd(afd):
    E = [0 if i not in afd.etatsFinaux[:afd.nbFinaux] else 1 for i in range(afd.nbEtats)]
    groups =[[0]*afd.nbSymboles for _ in range(len(E))]
    bilan0=E.copy()
    while True:
        bilan=[0]*len(E)
        for index in range(len(E)):
            for sin in range(afd.nbSymboles):
                groups[index][sin]=bilan0[(afd.transition[index][sin])]
        dic={}
        group=0
        for i in range(len(E)):
            t=tuple(groups[i])
            if t not in dic:
                dic[t]=group
                group+=1
            bilan[i]=dic[t]
        
        if bilan==bilan0:
            break
        bilan0=bilan.copy()


    new_afd = Automate()
    new_afd.nbEtats = max(bilan) + 1
    new_afd.nbSymboles = afd.nbSymboles
    new_afd.etatInitial = bilan[afd.etatInitial]
    new_afd.nbFinaux = 0
    for i in range(afd.nbEtats):
        if E[i] == 1:
            final_state = bilan[i]
            if final_state not in new_afd.etatsFinaux[:new_afd.nbFinaux]:
                new_afd.etatsFinaux[new_afd.nbFinaux] = final_state
                new_afd.nbFinaux += 1
    for i in range(afd.nbEtats):
        for j in range(afd.nbSymboles):
            new_afd.transition[bilan[i]][j] = bilan[afd.transition[i][j]]

    return new_afd



afd = Automate()
initialiser(afd)



# Optional: display the automaton
print("\n--- Automate construit ---")
afichage(afd)
print("________________________________________________________________________________________________________________________")

print("\n--- Automate minimisé ---")

minimized_afd = min_afd(afd)
afichage(minimized_afd)


#representation graphique 

def draw_automate(A: Automate, filename="afd"):
    g = Digraph(format='png')
    g.attr(rankdir='LR')

    # noeud invisible pour départ
    g.node('', shape='none')
    g.edge('', str(A.etatInitial))

    # états
    for i in range(A.nbEtats):
        if i in A.etatsFinaux[:A.nbFinaux]:
            g.node(str(i), shape='doublecircle')
        else:
            g.node(str(i), shape='circle')

    # transitions
    for etat in range(A.nbEtats):
        for symb in range(A.nbSymboles):
            dest = A.transition[etat][symb]
            g.edge(str(etat), str(dest), label=str(symb))

    g.render(filename, view=True)         


draw_automate(afd, "automate_construit")
draw_automate(minimized_afd, "automate_minimise")