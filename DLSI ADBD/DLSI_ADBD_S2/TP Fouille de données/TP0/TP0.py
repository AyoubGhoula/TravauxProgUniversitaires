import pandas as pn
import numpy as np
data={'Name':["Anastasia","Dima","Katherine","James","Emily","Michael","Matthew","Laura","Kevin","Jonas"],
     'score':[12.5,9.0,16.5,np.NaN,9.0,20.0,14.5,np.NaN,8.0,19.0],
     'attempts':[1,3,2,3,2,3,1,1,2,1],
     'qualify':["yes","no","yes","no","no","yes","yes","no","no","yes"]
     }
df=pn.DataFrame(data,index=[chr(ord('A')+i) for i in range(len(data['Name']))])
print(df)
print("________________________________________________________________")
print(df.head(3))
print("________________________________________________________________")
df['Nord']=df['score']>10.0
print(df)
df.drop('')
print("________________________________________________________________")
print(df[['Name','score']])
print("________________________________________________________________")
print(df.loc[["A",'C','E','F'],['Name','score']])
