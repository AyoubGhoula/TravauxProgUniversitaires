#1. Importez numpy comme np et affichez le numéro de version.
import numpy as np 
print(np.__version__)
#2. Créez un tableau 1D « arr » de nombres de 0 à 9.
arr=np.array(range(0,10))
print(arr)
#3. Extraire tous les nombres impairs de arr
print(arr[arr%2==0])
#4. Remplacez tous les nombres impairs dans arr par -1.
print("4__________________________________________________")
arr[arr%2==0]=-1
print(arr)
#5. Remplacez tous les nombres impairs dans arr par -1 sans changer arr.
print("5__________________________________________________")
arr1=np.where(arr%2==1,-1,arr)
print(arr1)
#6. Convertir le tableau arr en un tableau 2D avec 2 lignes.
print("6__________________________________________________")
arr2 = arr.reshape(2, -1)
print(arr2)
#7. À partir du tableau 1D arr, supprimez tous les éléments présents dans le tableau b.
print("7__________________________________________________")
b = np.array([8,9,10,11,12])
arr1 = np.setdiff1d(arr, b)
print(arr1)
#8. Inverser les lignes d'un tableau 2D arr.
print("8__________________________________________________")
arr = np.arange(9).reshape(3,3)
arr=arr[::-1]
print(arr)
#9. Inverser les colonnes d'un tableau 2D arr.
print("9__________________________________________________")
arr = np.arange(9).reshape(3,3)
arr=arr[:,::-1]
print(arr)
#10. Imprimez rand_arr en supprimant la notation scientifique (comme1e10).
print("10__________________________________________________")
np.random.seed(100)
rand_arr = np.random.random([3,3])*1e3
np.set_printoptions(suppress=True,precision=6)
print(rand_arr)
#11. Importez le jeu de données iris en conservant le texte intact.
print("11__________________________________________________")
url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data'
iris = np.genfromtxt(url,delimiter=',',dtype='object')
names = ('sepallength', 'sepalwidth', 'petallength', 'petalwidth','species')
print(iris[:3])
#12. Extrayez la colonne de texte 'species' du tableau 1D iris importé dans la question précédente.
print("12__________________________________________________")
url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data'
iris_1d = np.genfromtxt(url, delimiter=',', dtype=None)
species = np.array([row[4] for row in iris_1d])
print(species[:4])
#13. Trouver la moyenne, la médiane et l'écart-type de « sepallength » de l'iris (1ère colonne).
print("13__________________________________________________")
sepallength = np.genfromtxt(url, delimiter=',', dtype='float', usecols=[0])
moyenne = np.mean(sepallength)
median = np.median(sepallength)
ecart_type = np.std(sepallength)
print("Moyenne:", moyenne)
print("Médiane:", median)
print("Écart-type:", ecart_type)

