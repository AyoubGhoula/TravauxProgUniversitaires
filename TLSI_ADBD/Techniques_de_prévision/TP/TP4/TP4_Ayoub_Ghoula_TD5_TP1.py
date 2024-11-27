import numpy as np
import matplotlib.pyplot as plt


t=np.array([1,2,3,4,5,6,7])
Y=np.array([120,155,125,202,180,235,240])


#1. Représenter graphiquement la série par un nuage de points.

plt.scatter(t, Y, color='blue')
plt.xlabel("temps")
plt.ylabel("Chiffre d’affaire")
plt.title("nuage de points avec Matplotlib")
plt.legend()
plt.show()

#2. Déterminer l’équation de la droite de tendance en utilisant la méthode des points ettrêmes.


a=(Y[len(Y)-1]-Y[0])/(t[len(t)-1]-t[0])
b=Y[0]-a*t[0]

print("a = ",a)
print("b = ",b)
print("l’équation de la droite : Xt=",a,"t+",b)


#3. Représenter cette équation sur le même graphique.

plt.plot(t,a*t+b,color='red')

plt.show()


#4. Déterminer la prévision pour t=8.

t8=a*8+b

print("t8 = ",t8)
