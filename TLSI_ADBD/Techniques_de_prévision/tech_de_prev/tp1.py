"""EX1"""

from math import *
a=5
b=6
print("a=",a,"b=",b)
print("a+b=",a+b)
print("a/b=",a/b)
print("a%b=",a%b)
print("a**b=",a**b)
print("sqrt(a)=",sqrt(a))



"""EX2"""
print("---------------------------------\n Ecrire un programme en Python qui demande à l'utilisateur de saisir deux nombres a et b et de lui afficher leur maximum.")

a=int(input("donner a :"))
b=int(input("donner b :"))
print(max(a,b))


"""EX3"""
print("---------------------------------\n Ecrire un programme qui demande à l'utilisateur de saisir un nombre entier a et de lui afficher si ce nombre est pair ou impair")
a=int(input("donner a :"))
print("a est pair" if a%2==0 else "a est impair")


"""EX4"""
print("---------------------------------\nEcrire un programme qui permet de calculer la moyenne de 5 entiers :")

a=0
for i in range(1,6):
    a=a+i
print(a/5)

"""EX5"""
print("---------------------------------\nEcrire un programme qui permet de compter le nombre des voyelles dans une chaine des caractères")

ch=input( "donner une chaine : ")
a=0
for i in ch :
    if i.lower() in ["a","e","u","i","o","y"]:
        a=a+1
print(a)

"""EX6"""
print("---------------------------------\nEcrire un programme qui permet de retourner le premier et le dernier élément d’une liste de chaine de caractères :")

l=["aaaa","bbbbb","cccc","dddddd","fffff"]
print(l)
print(l[0],l[len(l)-1])



"""EX7"""

print("---------------------------------\nEcrire une fonction qui permet d’afficher les 100 premiers entiers :")

def aff ():
    l=[i for i in range(101)]
    print(l)


aff()


"""EX8"""

print("---------------------------------\nEcrire une fonction qui permet de retourner le factoriel d’un entier")

def fac(x):
    b=1
    for i in range(2,x+1):
        b=b*i
    print(x,"!=",b)

a=int(input("donner a :"))
fac(a)

