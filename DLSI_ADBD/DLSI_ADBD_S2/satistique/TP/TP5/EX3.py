import scipy.stats as stats
#Q1
moyenne=100
ecart_type=10
scoreA=90
scoreB=110
z_A=(scoreA-moyenne)/ecart_type
z_B=(scoreB-moyenne)/ecart_type
x=stats.norm.cdf(z_B)-stats.norm.cdf(z_A)
print(x)
#Q2
scoreC=120
scoreD=90
z_C=(scoreC-moyenne)/ecart_type
z_D=(scoreD-moyenne)/ecart_type
x=stats.norm.cdf(z_C)-stats.norm.cdf(z_D)
print(x)


