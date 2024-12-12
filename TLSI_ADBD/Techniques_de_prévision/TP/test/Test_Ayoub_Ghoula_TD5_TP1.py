import numpy as np
import matplotlib.pyplot as plt
import pandas as pd

#1) Charger les données depuis le fichier data.txt.
data=pd.read_csv('data.txt', delimiter=',',header=0)
print(data)

data=np.array(data)
#2) Tracer un nuage de points des données avec les mois en abscisse et les ventes en ordonnée.
mois=data[:,0]
ventes=data[:,1]
plt.scatter(mois,ventes)
plt.xlabel('mois')
plt.ylabel('ventes')
plt.show()

#3) Calculer l’équation de la droite d’ajustement en utilisant la méthode des points extrêmes.

x_min=data[:,0].min()
x_max=data[:,0].max()
y_min=data[:,1].min()
y_max=data[:,1].max()

a=(y_max-y_min)/(x_max-x_min)
b=y_min-a*x_min

print("l’équation de la droite t=",a,"*x+",b)

#4) Calculer la prévision des ventes pour le mois numéro 51 en utilisant l’équation de la droite.

v_51=a*51+b
print("ventes pour le mois numéro 51 = ",v_51)

#6) Calculer la prévision des ventes pour le mois numéro 51 en utilisant methode de mayer ?

x_first=np.mean(data[:(len(data)//2+len(data)%2),0])
x_last=np.mean(data[(len(data)//2+len(data)%2):,0])
y_first=np.mean(data[:(len(data)//2+len(data)%2),1])
y_last=np.mean(data[(len(data)//2+len(data)%2):,1])

print("first(",x_first,",",y_first,")")
print("last(",x_last,",",y_last,")")

a=(y_last-y_first)/(x_last-x_first)
b=y_first-a*x_first

print("l’équation de la droite en utilisant methode de mayer t=",a,"*x+",b)

v_51=a*51+b

print("ventes pour le mois numéro 51 en utilisant methode de mayer =",v_51)