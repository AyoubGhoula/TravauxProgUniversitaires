import numpy as np
import matplotlib.pyplot as plt



t=np.array([1,2,3,4,5,6,7])
ca=np.array([120,155,125,202,180,235,240])

#1. Représenter graphiquement la série par un nuage de points.

plt.scatter(t,ca, color='blue')
plt.xlabel("temps")
plt.ylabel("Chiffre d’affaire")
plt.title("nuage de points avec Matplotlib")
plt.legend()


#2. Déterminer les deux points moyens.

t_mean1=np.mean(t[:(len(t)//2)+(len(t)%2)])
ca_mean1=np.mean(ca[:(len(t)//2)+(len(t)%2)])
t_mean2=np.mean(t[(len(t)//2)+(len(t)%2)::])
ca_mean2=np.mean(ca[(len(t)//2)+(len(t)%2)::])

print("t_mean = ",t_mean1)
print("ca_mean = ",ca_mean1)
print("t_mean = ",t_mean2)
print("ca_mean = ",ca_mean2)

#3. Afficher les deux points dans le même graphique de la série
plt.scatter([t_mean1,t_mean2],[ca_mean1,ca_mean2], color='red')



#4. Déterminer la droite d’ajustement selon la méthode des moyennes doubles (Mayer).

a=(ca_mean2-ca_mean1)/(t_mean2-t_mean1)
b=ca_mean1-a*t_mean1
print("a = ",a)
print("b = ",b)
print("l’équation de la droite : Xt=",a,"t+",b)


#5. Représenter la droite de tendance sur le même graphique.
plt.plot(t,a*t+b,color='red')
plt.show()

#6. Déterminer la prévision pour t=8.
t8=a*8+b
print("t8 = ",t8)



#7. Déterminer la droite de tendance de cette série en utilisant la méthode des moindres carrés.

a_MC=(np.sum(t*ca)-len(t)*np.mean(t)*np.mean(ca))/(np.sum(t**2)-len(t)*np.mean(t)**2)
b_MC=np.mean(ca)-a_MC*np.mean(t)
print("a_MC = ",a_MC)
print("b_MC = ",b_MC)
print("l’équation de la droite : Xt=",a_MC,"t+",b_MC)

#8. Prévoir les ventes pour t=8.
t8_MC=a_MC*8+b_MC
print("t8 avec methode des moidres carres = ",t8_MC)

