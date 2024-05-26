import numpy as np
import pandas as pd
even_data=pd.read_csv("Building_Permits.csv")
print(even_data)
# set seed for reproducibility
np.random.seed(101)
# Affichez les cinq premières lignes du DataFrame sf_permits.
# print(even_data.head(5))
# # print tous les valuer  NaN
# print(even_data.isnull().sum())
# # change tous les valuer NaN en moy de la colonne
# even_data=even_data.fillna(0)
# print(even_data.head())
# print(even_data.isnull().sum())
# # remove all the rows that contain a missing value
# even_data.dropna()
# # remove all columns with at least one missing value
# columns_with_na_dropped = even_data.dropna(axis=1)
# columns_with_na_dropped.head()
# # just how much data did we lose?
# print("Columns in original dataset: %d \n" % even_data.shape[1])
# print("Columns with na's dropped: %d" % columns_with_na_dropped.shape[1])
# # get a small subset of the even dataset
# subset_even_data = even_data.sample(n=10, random_state=42)
# print(subset_even_data)
# # replace all NA's with 0
# subset_even_data.fillna(0)
# # replace all NA's the value that comes directly after it in the same column, 
# # then replace all the remaining na's with 0
# subset_even_data.fillna(method='bfill', axis=0).fillna(0)
# 2) Combien de points de données manquants avons-nous ? Quel pourcentage des valeurs dans l'ensemble de données sont manquantes ? Votre réponse doit être un nombre entre 0 et 100. (Si 1/4 des valeurs dans l'ensemble de données sont manquantes, la réponse est 25.)
total_values = np.product(even_data.shape)
missing_values = even_data.isnull().sum().sum()
missing_percentage = (missing_values / total_values) * 100
print(f"The dataset has {missing_values} missing values, which is {missing_percentage:.2f}% of the total values.")
"""3) Comprenez pourquoi les données sont manquantes
Examinez les colonnes "Street Number Suffix" et "Zipcode" de l'ensemble de données des permis de construire. Les deux contiennent des valeurs manquantes.

Lesquelles, le cas échéant, manquent parce qu'elles n'existent pas ?
Lesquelles, le cas échéant, manquent parce qu'elles n'ont pas été enregistrées ?"""
# Examiner la colonne "Street Number Suffix"
print(even_data['Street Number Suffix'].isnull().sum())
# Il semble que les valeurs manquantes dans cette colonne
"""5) Supprimer les valeurs manquantes : colonnes
Maintenant, essayez de supprimer toutes les colonnes avec des valeurs vides.

Créez un nouveau DataFrame appelé sf_permits_with_na_dropped qui a toutes les colonnes avec des valeurs vides supprimées.
Combien de colonnes ont été supprimées du DataFrame sf_permits original ? Utilisez ce nombre pour définir la valeur de la variable dropped_columns ci-dessous."""
# Supprimer les colonnes avec des valeurs vides
sf_permits_with_na_dropped = even_data.dropna(axis=1)
dropped_columns = even_data.shape[1] - sf_permits_with_na_dropped.shape[1]
print(f"{dropped_columns} columns were dropped from the original DataFrame.")
"""6) Remplir automatiquement les valeurs manquantes
Essayez de remplacer tous les NaN dans les données sf_permits par celui qui vient immédiatement après, puis remplacez tous les NaN restants par 0. Définissez le résultat sur un nouveau DataFrame sf_permits_with_na_imputed."""
sf_permits_with_na_imputed = even_data.fillna(method='bfill', axis=0).fillna(0)
print(sf_permits_with_na_imputed)
