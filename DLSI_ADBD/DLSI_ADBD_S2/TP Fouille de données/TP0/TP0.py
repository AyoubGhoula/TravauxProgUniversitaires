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
# df['Nord']=df['score']>10.0
# print(df)
# df.drop('Nord')
print("________________________________________________________________")
print(df[['Name','score']])
print("5________________________________________________________________")
print(df.loc[["A",'C','E','F'],['Name','score']])
selected_rows = df[df['attempts'] > 2]
print("6 ________________________________________________________________")
print(selected_rows)
print("7 ________________________________________________________________")
col_count=len(df.keys())
row_count=len(df['Name'])
print("col: ",col_count," , row : ",row_count)
print("8 ________________________________________________________________")
select_row=df[df['score'].isnull()]
print(select_row)
print("9 ________________________________________________________________")
select_row=df[df['score'].isin((range(15,21)))]
print(select_row)
print("10 ________________________________________________________________")
select_row=df[(df['score']>15) & (df["attempts"]<2)]
print(select_row)
print("11 ________________________________________________________________")
df.loc['D', 'score'] = 11.5
print(df)
print("12 ________________________________________________________________")
sum_attempts=sum(df["attempts"])
print("sum = ",sum_attempts)
print("13 ________________________________________________________________")
moy_score= df["score"].mean()
print("moyen=",moy_score)
print("14 ________________________________________________________________")
df.loc['k'] = [input("donner les valuer : ") for i in range (col_count) ]
print(list(df.loc['k']))
print(df)
print("15 ________________________________________________________________")
df = df.drop('k')
print(df)
print("16 ________________________________________________________________")
