import pandas as pd
from sklearn.preprocessing import StandardScaler
import seaborn as sns
import matplotlib.pyplot as plt
# Importer le jeu de données seeds.csv dans un DataFrame X
X=pd.read_excel("seeds.xlsx")
print(X) 
#Sélectionner les colonnes nécessaires dans l’objectif d’analyser les dépendances entre les grains et la recherche des similarités. (Modification sur X)
X=X[['Area','Perimetre','compactness ','kLength','kWidth','AsymmetryCoef','kGrooveL']]
print(X.columns)
# Remplacer les valeurs manquantes dans chaque colonne par la moyenne de la variable
X=X.fillna(X.mean())
print(X)
#Standardiser les données en utilisant la classe StandardScaler de la bibliothèque sklearn.
scaler=StandardScaler()
X_scaled=scaler.fit_transform(X)
X_scaled=pd.DataFrame(X_scaled,columns=X.columns)
print(X_scaled)
# Vérifiez les moyennes et les écarts types après la standardisation.
mean_std=pd.DataFrame({'mean':X_scaled.mean(),'std':X_scaled.std()})
print(mean_std)
# Afficher et analyser la matrice de corrélation
corr=X_scaled.corr()
# Quels sont les couples de variables les plus corrélées.
print(corr.unstack().sort_values(ascending=False))
#Visualiser et analyser les dépendances des variables 2 à 2 en faisant le lien avec la matrice de corrélation.
sns.pairplot(X)
plt.show()
# 


