import numpy as np
import scipy.stats as st
data=[124,101,115,126,114,112,138,85,138,96,130,116,132]
def df1(data):
    mean=round(np.mean(data),2)
    print(mean)
    median=(np.median(data))
    print(median)
    mode=st.mode(data)
    print(mode)
    etendue=np.ptp(data)
    print(etendue)
    variance=round(np.var(data,ddof=1),2)
    print(variance)
    ecart=round(np.std(data),2)
    print(ecart)
df1(data)
data[-1]=175
print(data)
df1(data)
