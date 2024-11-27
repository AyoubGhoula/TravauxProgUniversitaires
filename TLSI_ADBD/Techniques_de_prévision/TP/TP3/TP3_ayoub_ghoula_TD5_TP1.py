import numpy as np
import matplotlib.pyplot as plt

X=np.array([1,2,3,4,5,6,7,8,9,10])
Y=np.array([8000,9000,9500,9700,9800,9800,11000,12000,12500,13000])

plt.scatter(X, Y, color='blue')
plt.xlabel("année")
plt.ylabel("PIB")
plt.title("nuage de points avec Matplotlib")
plt.legend()
plt.show()


"""2. Déterminer l’équation de la droite de l’ajustement en utilisant la méthode des
moindres carrés."""
moyenne_X = np.mean(X)
moyenne_Y = np.mean(Y)
A=(np.sum(X*Y)/len(X)-moyenne_X*moyenne_Y)/((np.sum(X**2)/len(X))-(moyenne_X**2))
B=moyenne_Y-A*moyenne_X

print(A)
print(B)






"""3. Calculer le coefficient de corrélation correspondant"""

n = len(X)



XY = X * Y
X2 = X**2
r = (np.mean(XY) - moyenne_X * moyenne_Y) / (np.sqrt(np.mean(X2) - moyenne_X**2) * np.sqrt(np.mean(Y**2) - moyenne_Y**2))
print(f"Coefficient de corrélation (r) : {r:.2f}")

"""4. Représenter cette droite sur le même graphique."""
plt.scatter(X, Y, color='blue')
plt.plot(X, A * X + B, color='red', label='Ajustement <')

plt.xlim(0)
plt.xlabel("X")
plt.ylabel("Y")
plt.title("nuage de points avec Matplotlib")
plt.legend()
plt.show()


"""5. Déterminer le produit intérieur brut prévu pour l’année suivante."""

annee=11
PIB11=A*annee+B
print("annee : ",annee,"de PIB : ",PIB11)


