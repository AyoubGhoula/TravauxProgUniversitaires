import numpy as np
import matplotlib.pyplot as plt 



#1) En utilisant le tableau ci-dessus, écrire un programme python qui permet de créer une matrice de 6 colonnes dont les éléments sont les suivants :

years = np.array([2018, 2019, 2020, 2021, 2022, 2023])
trimestre_data = np.array([
    [520, 650, 1500, 710], 
    [550, 690, 1660, 790], 
    [610, 720, 1820, 830], 
    [680, 780, 1900, 880], 
    [750, 860, 1980, 950], 
    [880, 940, 2100, 1100]
])

# 1. Calculating the required matrix
year_index = np.arange(1, 7)
annual_average_sales = np.array(np.mean(trimestre_data, axis=1))
print(annual_average_sales)
sum_sales = np.sum(trimestre_data, axis=1)

product_index_sum = year_index * sum_sales
sum_squared_sales = np.sum(trimestre_data**2, axis=1)
total_average_sales = np.mean(sum_sales)

# # Creating the matrix
# matrix = np.array([year_index, annual_average_sales, product_index_sum, sum_squared_sales, total_average_sales])

# # Print the matrix
# print(matrix)
