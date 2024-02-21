
# dic_ani={"ayoub ghoula":"19/1/2009","khaled kashmiri":"12/7/2000","mouhisin kodaii":"20/7/1999"}
# print(" Bienvenue dans le dictionnaire d'anniversaire. Nous connaissons les anniversaires de :\n")
# for i in dic_ani.keys():
#     print(i+"\n")
# print("De qui voulez-vous connaître l'anniversaire ?")
# n=input()
# print("L'anniversaire de "+ n+ " est le "+dic_ani[n])

# with open('json_ex2.json','r') as file:
#     dic_ani=json.load(file)
# print("donner nom :")
# nom=input()
# print("L'anniversaire de "+ nom+": ")
# ani=input()
# dic_ani[nom]=ani
# with open('json_ex2.json', 'w') as file:
#     json.dump(dic_ani, file)

# print("Updated dictionary:", dic_ani)
import json

with open('json_ex2.json', 'r') as file:
    dic_ani=json.load(file)

print("Enter name:")
nom = input()
print("Enter the anniversary for " + nom + ":")
ani = input()
dic_ani[nom] = ani
with open('json_ex2.json', 'w') as file:
    json.dump(dic_ani,file,indent=2)

print("Updated dictionary:", dic_ani)

