import pandas as pd
import matplotlib.pyplot as plt
from matplotlib.ticker import PercentFormatter
# Création du DataFrame
data = {'Catégories': ['Compte ou service bancaire', 'Prêt à la consommation', 'Carte de crédit', 'Rapports de crédit', 'RRecouvrement de créances ', 'Compte ou service bancaire']
,'effectifs': [152, 82, 125, 981, 686, 92, 25, 22]}
df = pd.DataFrame(data) # on va créer une var.... un tableau de type dataframe
# Trier les catégories par ordre décroissant par rapport au nombre de réclamations
df = df.sort_values(by='effectifs',ascending=False)
# Calculer les fréquences
df["frequences"] = (df["effectifs"]/df["effectifs"].sum()).round(2)
# Calculer les fréquences cumulées
df["frequences_cum"] = df["frequences"].cumsum().round(2)
print(df)
# Create just a figure and only one subplot
# using the variable ax for single a Axes
fig, ax = plt.subplots()
ax.bar(df['Catégories'], df["effectifs"], color="C0")
ax2 = ax.twinx()
ax2.plot(df['Catégories'], df["frequences_cum"], color="C1", marker="D", ms=7)
ax2.yaxis.set_major_formatter(PercentFormatter())
plt.show()