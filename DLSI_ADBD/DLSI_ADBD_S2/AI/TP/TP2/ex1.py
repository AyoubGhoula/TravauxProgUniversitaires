import numpy as np 
liste=[np.random.randint(1,101) for _ in range(100)]
print(liste)
print("1__________________________________________________")
print([i for i in liste if i<20])
print("2__________________________________________________")
list_inf_20=[i for i in liste if i<20]
print(list_inf_20)
print("3__________________________________________________")
n=int(input("donner un nombre : "))
print("es éléments inférieurs à ce nombre de la liste est : ",[i for i in liste if i<n])
print("4__________________________________________________")
print("es indices des éléments inférieurs à 20 dans la liste",[i for i in range(len(liste)) if liste[i]<20])
print("5__________________________________________________")
def fonc(list, k):
    return [i for i in list if i < k]
print(fonc(liste,15))
print("6__________________________________________________")
filtered_list = list(filter(lambda x: x < 20,liste))
print("Liste filtrée avec une fonction lambda:", filtered_list)
print("7__________________________________________________")
sum_inf_20 = sum(i for i in liste if i < 20)
print(sum_inf_20)


