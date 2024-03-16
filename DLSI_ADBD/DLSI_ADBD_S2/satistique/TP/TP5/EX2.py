import scipy.stats as stats
Acme_dure=365
moyenne=300
ecart_type=50
z=(Acme_dure-moyenne)/ecart_type
x=1-stats.norm.cdf(z)
print(x)