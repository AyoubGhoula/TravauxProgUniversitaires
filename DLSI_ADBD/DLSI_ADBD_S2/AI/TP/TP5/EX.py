import numpy as np
import pandas as pd
even_data=pd.read_csv("Building_Permits.csv")
print(even_data)
# set seed for reproducibility
np.random.seed(101)
#Affichez les cinq premières lignes du DataFrame sf_permits.
print(even_data.head(5))
# print tous les valuer  NaN
print(even_data.isnull().sum())
# change tous les valuer NaN en moy de la colonne
even_data=even_data.fillna(0)
print(even_data.head())
print(even_data.isnull().sum())
