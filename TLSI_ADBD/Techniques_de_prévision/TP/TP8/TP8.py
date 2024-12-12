import numpy as np
import matplotlib.pyplot as plt
import pandas as pd



a=pd.read_csv('Techniques_de_prévision\TP\TP7\serie.txt', delimiter=',',header=0)
print(a)


#2. Créer deux variables S-1 et T-1 et les initialiser comme suite :

#T-1=(serie1[364]-serie1[0]) /364 ;

T=(a[364][1]-a[0][1])/364

print(T)


#S-1= serie1[0]-0.5* T-1
S=a[0][1]-0.5*T

print(S)

#3. Créer deux listes S et T et les remplir itérativement de la façon suivante :

#Ti = 0.2*(Si - Si-1) + 0.8*Ti-1 avec i ε[0..364]
 
List_L=[]

for i in range(0,365):
    if i==0:
        List_L.append(0.2*(S-S)+0.8*T)
    else:
        List_L.append(0.2*(S-List_L[i-1])+0.8*List_L[i-1])

print(List_L)

#Si = 0.1*serie1[i] + 0.9 *(Si-1 + Ti-1) ;

List_S=[]

for i in range(0,365):
    if i==0:
        List_S.append(0.1*a[i][1]+0.9*(S+T))
    else:
        List_S.append

print(List_S)


List_P=[]

for i in range(0,365):
    List_P.append(List_S[i]+List_L[i])




#Afficher la liste des prévisions.

print(List_P)