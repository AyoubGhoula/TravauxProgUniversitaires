import numpy as np
import matplotlib.pyplot as plt

#_____________________________________________________________________


X=np.array([1,3,3,5])
Y=np.array([3,4,6,5])

plt.scatter(X,Y,color='blue')
plt.show()
X_mean=np.mean(X)
y_mean=np.mean(Y)

A=(np.sum(X*Y)/len(X)-X_mean*y_mean)/((np.sum(X**2)/len(X))-(X_mean**2))
B=y_mean-A*X_mean

print(A)
print(B)


# Tracer la droite de l’ajustement
plt.scatter(X, Y, color='blue')
plt.plot(X, A * X + B, color='red', label='Ajustement <')

plt.xlim(0)
plt.xlabel("X")
plt.ylabel("Y")
plt.title("nuage de points avec Matplotlib")
plt.legend()
plt.show()


#Calculer le coefficient de corrélation (équation 4)

n = len(X)

moyenne_X = np.mean(X)
moyenne_Y = np.mean(Y)

XY = X * Y
X2 = X**2
r = (np.mean(XY) - moyenne_X * moyenne_Y) / (np.sqrt(np.mean(X2) - moyenne_X**2) * np.sqrt(np.mean(Y**2) - moyenne_Y**2))
print(f"Coefficient de corrélation (r) : {r:.2f}")




