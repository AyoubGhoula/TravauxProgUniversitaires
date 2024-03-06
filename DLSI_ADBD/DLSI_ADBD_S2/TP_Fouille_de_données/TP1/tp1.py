import pandas as pn
from datetime import datetime
df=pn.read_csv("empls.csv",)
print(df)
date_str=df["Date_emb"]
date_false=[]
try:
    datetime.strptime(date_str,"%d-%m-%y" )
except:
    date_false.append(date_str)
# Q4
print("4____________________________________________________________________________")
print("Vérification des doublons :")
duplicates = df.duplicated().sum()
if duplicates > 0:
    print(f"Il y a {duplicates} doublons dans la base de données.")
    df.drop_duplicates(inplace=True)
    print("Les doublons ont été supprimés.")
else:
    print("Il n'y a pas de doublons dans la base de données.") 

# Q5
print("5____________________________________________________________________________")
print("\nRemplacement des valeurs NaN par Zéro :")
df.fillna(0, inplace=True)
print(df)
"""max_date_embau = df['Date_embau'].max()

# Remplacer les valeurs aberrantes par la valeur maximale
df['Date_embau'] = df['Date_embau'].apply(lambda x: max_date_embau if pd.isnull(x) or x == 0 else x)"""
#Q6
print("6____________________________________________________________________________")
max_value = df['Salaire'].max()
if max_value != 0:
    print(f"Il y a des valeurs aberrantes dans la variable 'Date_embau'.")
    print(f"La valeur maximale de 'Salaire' est {max_value}.")
    df['Salaire'].replace(0, max_value, inplace=True)
    print("Les valeurs aberrantes ont été remplacées par la valeur maximale.")
    print(df)
else:
    print("Il n'y a pas de valeurs aberrantes dans la base de données.")
#Q7
print("7____________________________________________________________________________")
mapping_poste = {poste: index for index, poste in enumerate(df['poste'].unique())}
df['poste'] = df['poste'].replace(mapping_poste)
print(df)
#Q8
print("8____________________________________________________________________________")
mapping_Nom={poste:index for index ,poste in enumerate(df["Nom"].unique())}
df['Nom']=df['Nom'].replace(mapping_Nom)
mapping_Date={poste:index for index ,poste in enumerate(df["Date_emb"].unique())}
df['Date_emb']=df['Date_emb'].replace(mapping_Date)

mean_values = df.mean()
std_values = df.std()
data_Y = df.sub(mean_values)
data_Z = data_Y.div(std_values)
print("Matrice Y des données centrées :")
print(data_Y)
print("\nMatrice Z des données centrées et réduites :")
print(data_Z)





  

