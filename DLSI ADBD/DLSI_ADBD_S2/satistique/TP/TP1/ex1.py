import matplotlib.pyplot as plt
Liste=["A","A","A","A","A","A","A","A","A","A","A","A","A","A","A","C","C","C","C","C","C","C","C","C","C","C","C","C","C","C","M","M","M","M","M","M","M","M","M","M"]
Liste.sort()
n=len(Liste)
print(n)
cara=[]
efec=[]
fri=[]
angle=[]
print()
for i in range(n):
    if Liste[i] not in cara:
        cara.append(Liste[i])
        efec.append(Liste.count(Liste[i]))
        fri.append(Liste.count(Liste[i])/n)
        angle.append((Liste.count(Liste[i])/n)*360)
         
print("caractare ","efectif ","frequence")
for i in range(len(cara)):
    print("   "+cara[i]+"        "+str(efec[i])+"       "+str(round(fri[i],2)))
plt.bar(cara,efec,width=0.5)
plt.show()
plt.pie(angle,labels=cara,autopct='%1.1f%%')
plt.show()