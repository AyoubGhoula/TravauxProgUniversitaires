import numpy as np 
liste=[np.random.randint(1,101) for _ in range(100)]
print(liste)
print([i for i in liste if i<20])