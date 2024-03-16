import os
import cv2
import pandas as pd
import numpy as np

def traiter_images(chemin_dossier):
    # 1. Lire les images dans une liste
    images = []
    for fichier in os.listdir(chemin_dossier):
        if fichier.endswith(".jpg") or fichier.endswith(".png"): 
            image = cv2.imread(os.path.join(chemin_dossier, fichier))
            images.append(image)
    
    # 2. Vérifier et redimensionner les images        
    dimensions = set([img.shape[:2] for img in images])
    if len(dimensions) > 1:
        dimension_cible = (64, 64)
        images = [cv2.resize(img, dimension_cible) for img in images]
    
    # 3. Créer le dataframe
    lignes = []
    for img in images:
        vecteur = img.reshape(-1) 
        lignes.append(vecteur)
        
    df = pd.DataFrame(lignes)
    
    # 4. Déterminer min et max des niveaux de gris
    niveaux_gris = df.values.flatten()
    min_gris = niveaux_gris.min()
    max_gris = niveaux_gris.max()
    print("Niveaux de gris entre {} et {}".format(min_gris, max_gris))
    
    # 5. Ajouter étendue et médiane
    df['etendue'] = df.max(axis=1) - df.min(axis=1) 
    df['mediane'] = df.median(axis=1)

    # 6. Trouver les images les plus similaires 
    df = df.sort_values(by=['etendue', 'mediane'])
    print("Les images les plus similaires sont :")
    print(df.head(2))
    
    return df
traiter_images("ADF\image1_tp.jpg")
