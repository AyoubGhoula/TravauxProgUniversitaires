import pandas as pn
from datetime import datetime
df=pn.read_csv("empl.csv")
print(df)
date_str=df["Date_emb"]
print(date_str)
date_false=[]
try:
    datetime.strptime(date_str,"%d-%m-%y" )
except:
    date_false.append(date_str)

print(date_false)
