import pandas as pn
import numpy as np
data={'Name':["Anastasia","Dima","Katherine","James","Emily","Michael","Matthew","Laura","Kevin","Jonas"],
     'score':[12.5,9.0,16.5,np.NaN,9.0,20.0,14.5,np.NaN,8.0,19.0],
     'attempts':[1,3,2,3,2,3,1,1,2,1],
     'qualify':["yes","no","yes","no","no","yes","yes","no","no","yes"]
     }
df=pn.DataFrame(data,index=[chr(ord('A')+i) for i in range(len(data['Name']))])
print(df)
print("1________________________________________________________________")
print(df.head(3))
print("2________________________________________________________________")
df['Nord']=df['score']>10.0
print(df)
print("3________________________________________________________________")
df=df.drop(columns=['Nord'])
print(df)
print("4________________________________________________________________")
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
df.loc['k'] = ["exemple",14,1,"yes"] #[input("donner les valuer : ") for i in range (col_count) ]
print(list(df.loc['k']))
print(df)
print("15 ________________________________________________________________")
df = df.drop('k')
print(df)
print("16 ________________________________________________________________")
print(df.sort_values(by='Name'))
print("17 ________________________________________________________________")
print(df.sort_values(by='score', ascending=False))
print("18 ________________________________________________________________")
df['qualify'] = df['qualify'].replace({'yes': True, 'no': False})
print(df)
print("19 ________________________________________________________________")
df['Name'] = df['Name'].replace('James', 'Suresh')
print(df)
print("20 ________________________________________________________________")
df=df.drop(columns=['attempts'])
print(df)
print("21 ________________________________________________________________")
df['nouv_col'] = '0'
print(df)
print("22 ________________________________________________________________")
for i in df.index:
    print(i," : ",df.loc[i])
print("23 ________________________________________________________________")
df['score'] = df['score'].replace(np.nan, 0)
print(df)
print("24 ________________________________________________________________")
df.at['A', 'score'] = 10 #float(input("donner un valeur : ")) 
print(df)
print("25 ________________________________________________________________")
nan_count = sum(df['score'].isna())
print("nombre de valeur nan : ",nan_count)
print("26 ________________________________________________________________")
liste=list(df.columns)
print("la liste des en-têtes des colonnes du DataFrame : ",liste)
print("27 ________________________________________________________________")
print(df.rename(columns={'Name': 'nom', 'score': 'note'}))
print("28 ________________________________________________________________")
lignes = df[df['score'] > 15]
print("les lignes avec un score > 15 : ",lignes)
print("29 ________________________________________________________________")
df = df[['score',"nouv_col", 'Name', 'qualify']]
print(df)
