import pandas as pd
import matplotlib.pyplot as plt
gender_data = ['M', 'M', 'M', 'F', 'M', 'F', 'F', 'M', 'F', 'M', 'F', 'M', 'M', 'M', 'M', 'F', 'F', 'M', 'F', 'F', 'M', 'M', 'M', 'M', 'F', 'M', 'F', 'F', 'M', 'M', 'F', 'M', 'M', 'M', 'F', 'M', 'F', 'M', 'M']
major_data = ['A', 'C', 'C', 'M', 'A', 'C', 'A', 'A', 'C', 'C', 'A', 'A', 'A', 'M', 'C', 'M', 'A', 'A', 'A', 'C', 'C', 'A', 'A', 'M', 'M', 'C', 'A', 'A', 'A', 'C', 'C', 'A', 'A', 'A', 'A', 'C', 'C', 'A', 'C']
contingence_table=pd.crosstab(index=pd.Series(gender_data,name="genre"),columns=pd.Series(major_data,name="major"),margins=True,margins_name="total")
print(contingence_table)
print("__________________________________________________________________"*2)
print("Répartition des étudiants par genre et spécialité")
contingence_table=pd.crosstab(index=pd.Series(gender_data,name="genre"),columns=pd.Series(major_data,name="major"),normalize=True,margins=True,margins_name="total")
print(contingence_table)




