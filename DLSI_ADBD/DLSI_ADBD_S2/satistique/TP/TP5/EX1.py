import scipy.stats as stats
score_maryeù=940
moyenne=850
ecart_type=100
z=(score_maryeù-moyenne)/ecart_type
x=1-stats.norm.cdf(z)
print(x)