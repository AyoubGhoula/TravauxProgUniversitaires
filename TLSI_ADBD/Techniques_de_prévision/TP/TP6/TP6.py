import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

#1. Récupérer le fichier data2.csv contenant 100 données des ventes mensuelles d’une entreprise et mettre les données dans une liste a.
a=pd.read_csv('Techniques_de_prévision\TP\TP6\data.csv', header=None).squeeze()
a = a.to_numpy()
print(len(a))
print(a)


#2. Calculer les prévisions dans une liste en utilisant la moyenne statistique et ceci du premier mois jusqu’au dernier mois.
print("#2. Calculer les prévisions dans une liste en utilisant la moyenne statistique et ceci du premier mois jusqu’au dernier mois.")
lits=[np.mean(a[:i]) for i in range(1,len(a)+1)]


#3. Afficher la liste des prévisions
print("#3. Afficher la liste des prévisions.")
print(len(lits))
print(lits)

#4. Quelle est la prévision des ventes pour le mois numéro 101.
print("#4. Quelle est la prévision des ventes pour le mois numéro 101.")

t_101=np.mean(a[:101])
print(t_101)


for i in range(len(a)):
    if i < 2:
        avg = np.mean(a[:i+1])  # Moyenne des données disponibles si moins de 3 mois
    else:
        avg = np.mean(a[i-2:i+1])  # Moyenne des trois derniers mois
    forecasts_last3.append(avg)