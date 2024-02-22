import json
# Part 1
dict_user = {"Benjamin Franklin" : "17/01/1706", 
             "Albert Einstein" : "15/02/1500" ,
             "Ada Lovelace" : "12/08/1600"}



print("Bienvenue dans le dictionnaire d'anniversaire. Nous connaissons les anniversaires de :")
for name in dict_user.keys() :
    print(name)
print("De qui voulez-vous connaître l'anniversaire ?")
input_name = input()
print("L'anniversaire de {} est le {}.".format(input_name, dict_user[input_name]))

# Part 2
with open('dict_users.json', 'r') as file:
    dict_users = json.load(file)


user_name = input("Donner Un Nom : ")
user_date = "/".join(input("Donner La Date : ").split())
dict_users[user_name] = user_date
with open('dict_users.json', 'w', encoding='utf-8') as file:
    json.dump(dict_users, file, indent=2, ensure_ascii=False)

# Part 3
mois_indices = {
    1: "janvier",
    2: "février",
    3: "mars",
    4: "avril",
    5: "mai",
    6: "juin",
    7: "juillet",
    8: "août",
    9: "septembre",
    10: "octobre",
    11: "novembre",
    12: "décembre"
}
with open('dict_users.json', 'r') as file :
    dict_users = json.load(file)
dict_months = dict()
for user_date in dict_users.values() :
    user_month = int(user_date.split('/')[1])
    if mois_indices[user_month] not in dict_months :
        dict_months[mois_indices[user_month]] = 0
    dict_months[mois_indices[user_month]] = 1
print(dict_months)