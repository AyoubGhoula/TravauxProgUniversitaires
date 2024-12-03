import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

#1. Récupérer le fichier serie1 contenant 365 données des naissances mensuelles .

a=pd.read_csv('Techniques_de_prévision\TP\TP7\serie.txt', delimiter=',',header=0)
print(a)

#mettre les données dans une liste serie
a=np.array(a)
print(a)

a_mois=[]
for i in range(1,13):
    a_mois.append([f"2021-{i:02d}",0])
    age=0
    c=0
    for j in a:
        date=j[0].split('-')
        if int(date[1])==i:
            age+=j[1]
            c+=1
    age=age/c
    a_mois[i-1][1]=age
print(a_mois)
a=a_mois
print(a)
#2. Créer une liste P et ajouter à cette liste la première valeur =35. Cette valeur sera considérée comme étant la première prévision.

p=[35]

"""3. Calculer les prévisions dans la liste P en utilisant la formule suivante et ceci du premier mois
jusqu’au dernier mois : P(i)=0.1*P(i-1)+0.9*serie(i-1) où i représente le i ème mois de
l’année."""

for i in range(1,len(a)):
    p.append(0.1*p[i-1]+0.9*a[i-1][1])


""" 4. Afficher la liste des prévisions"""

print(p)

""" 5. Mettre dans une liste erreur les erreurs de la prévision établie."""
E=[abs(a[i][1]-p[i]) for i in range(len(a))]
 
print(E)

"""6. Mettre dans une liste eq les erreurs quadratiques correspondantes."""

eq = [(a[i][1] - p[i])**2 for i in range(len(a))]

print(eq)

"""7. Calculer la moyenne des erreurs de la prévision établie."""
print("la moyenne des erreurs de la prévision établie")
moyenne_erreurs = np.mean(eq)
print(moyenne_erreurs)
