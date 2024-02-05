import matplotlib.pyplot as plt
ages=[43,64,45,55,43,38,64,55,47,64,29,46,29,64,43,39,19,55,29,19]
n=len(ages)
cara=sorted(list(set(ages)))
efec=[ages.count(i) for i in cara]
print(efec,cara)
freq=[c/n for c in efec]
freq_cum=[0]*len(cara)
freq_cum[0]=freq[0]
for i in range(1,len(cara)):
    freq_cum[i]=freq_cum[i-1]+freq[i]
print(freq_cum)
plt.xlabel("ages")
plt.ylabel("age effectif")
plt.title("diagrame en batons")
plt.bar(cara,freq,width=0.5)
plt.show()
plt.bar(cara,freq_cum,width=0.5)
plt.show()