import numpy as np 
print(np.__version__)
arr=np.array(range(0,10))
print(arr)
a=1
print(arr[arr%2==0])
# print("4__________________________________________________")
# arr[arr%2==0]=-1
# print(arr)
print("5__________________________________________________")
arr1=np.where(arr%2==1,-1,arr)
print(arr1)
print("6__________________________________________________")
arr2 = arr.reshape(2, -1)
print(arr2)
print("7__________________________________________________")
b = np.array([8,9,10,11,12])
arr1 = np.setdiff1d(arr, b)
print(arr1)
print("8__________________________________________________")
arr = np.arange(9).reshape(3,3)
arr=arr[::-1]
print(arr)
print("9__________________________________________________")
arr = np.arange(9).reshape(3,3)
arr=arr[:,::-1]
print(arr)
print("10__________________________________________________")
np.random.seed(100)
rand_arr = np.random.random([3,3])*1e3
np.set_printoptions(suppress=True,precision=6)
print(rand_arr)
print("11__________________________________________________")
url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data'
iris = np.genfromtxt(url,delimiter=',',dtype='object')
names = ('sepallength', 'sepalwidth', 'petallength', 'petalwidth','species')
print(iris[:3])
print("12__________________________________________________")
url = 'https://archive.ics.uci.edu/ml/machine-learning-databases/iris/iris.data'
iris_1d = np.genfromtxt(url, delimiter=',', dtype=None)

