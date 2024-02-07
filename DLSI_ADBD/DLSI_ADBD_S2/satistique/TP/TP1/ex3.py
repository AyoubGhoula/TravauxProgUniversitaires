import numpy as np
import matplotlib.pyplot as plt

gender = ['M', 'M', 'M', 'F', 'M', 'F', 'F', 'M', 'F', 'M', 'F', 'M', 'M', 'M', 'M', 'F', 'F', 'M', 'F', 'F', 'M', 'M', 'M', 'M', 'F', 'M', 'F', 'F', 'M', 'M', 'F', 'M', 'M', 'M', 'F', 'M', 'F', 'M', 'M']
major = ['A', 'C', 'C', 'M', 'A', 'C', 'A', 'A', 'C', 'C', 'A', 'A', 'A', 'M', 'C', 'M', 'A', 'A', 'A', 'C', 'C', 'A', 'A', 'M', 'M', 'C', 'A', 'A', 'A', 'C', 'C', 'A', 'A', 'A', 'A', 'C', 'C', 'A', 'C']

contingency_table = np.zeros((2, 3), dtype=int)
for i in range(len(gender)):
    if gender[i] == 'M':
        row = 0
    else:
        row = 1
    if major[i] == 'A':
        col = 0
    elif major[i]== 'C':
        col = 1
    else:
        col = 2
    contingency_table[row, col] += 1
major_categories = ['Administration', 'Comptabilité', 'Marketing']
plt.bar(np.arange(len(major_categories)), contingency_table[0], label='Masculin', width=0.3)
plt.bar(np.arange(len(major_categories)) + 0.4, contingency_table[1], label='Féminin', width=0.3)
plt.xlabel('Spécialité')
plt.ylabel("Nombre d'étudiants")
plt.title('Répartition des étudiants par genre et spécialité')
plt.xticks(np.arange(len(major_categories))+0.2, major_categories)
plt.show()
