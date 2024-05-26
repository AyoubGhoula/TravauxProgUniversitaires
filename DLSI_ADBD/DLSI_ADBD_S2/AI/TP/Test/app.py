# Data Set Information ::
#
#### Columns :
## userId, movieId, rating, timestamp.
#
#### Details:
## Ratings are expressed on a 5-star scale with half-star increments (0.5 to 5.0).
## Timestamps indicate the time of the rating since midnight of January 1, 1970 (UTC).

import pandas as pd
from scipy import stats

import numpy as np
from sklearn.model_selection import train_test_split

from sklearn.metrics import mean_absolute_error, mean_squared_error, mean_absolute_percentage_error
import matplotlib.pyplot as plt
from sklearn.linear_model import LinearRegression
from sklearn.preprocessing import StandardScaler
df = pd.read_csv("ratings.csv")

scaler = StandardScaler()
df = pd.DataFrame(scaler.fit_transform(df), columns=df.columns)

# Construction du modèle
X = df[["userId"]]
Y = df["rating"]

# Question 3 :: Entraînez un modèle de régression linéaire :

# Calculate linear regression
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)
model = LinearRegression()
model.fit(X_train, Y_train)


predicted_Y = model.predict(X_test)


# Question 4 :: Évaluez les performances du modèle :

mae = mean_absolute_error(Y_test, predicted_Y)

mse = mean_squared_error(Y_test, predicted_Y)

mape = mean_absolute_percentage_error(Y_test, predicted_Y)

print("Mean Absolute Error:", mae)
print("Mean Square Error:", mse)
print("Mean Absolute Percentage Error:", mape)


# Question 5 :: Répétez les étapes 1 à 3 pour chaque attribut :

attributes = ["movieId", "userId", "timestamp"]

# Define a function to train a linear regression model and return coefficients
def train_linear_regression(X_train, Y_train):
    model = LinearRegression()
    model.fit(X_train, Y_train)
    return model.coef_

# Calculate coefficients for each attribute
coefficients_dict = {}

for attribute in attributes:
    # Construction du modèle
    X = df[[attribute]]
    Y = df["rating"]

    # Split the data into training and testing sets
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)

    # Train the linear regression model and get coefficients
    coefficients = train_linear_regression(X_train, Y_train)

    # Store coefficients in the dictionary
    coefficients_dict[attribute] = coefficients

    
# # Question 6 :: Sélectionnez les attributs les plus dominants :

# Sort attributes based on absolute coefficients (dominance)
dominant_attributes = sorted(coefficients_dict.items(), key=lambda x: abs(x[1]), reverse=True)

# Print the dominant attributes and their coefficients
for attribute, coefficient in dominant_attributes:
    print(f"Attribute: {attribute}, Coefficient: {coefficient}")
# Get the most dominant attribute
most_dominant_attribute = dominant_attributes[0][0]  # Attribute with the highest absolute coefficient

print("Most Dominant attribute ::: " + most_dominant_attribute)



# # Question 7 :: 7. Entraînez un nouveau modèle de régression linéaire avec seulement les attributs les plus dominants sélectionnés.

# Separate the features (X) and target variable (Y) based on dominant attributes
X = df[[most_dominant_attribute]]
Y = df["rating"]

# Split the data into training and testing sets
X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.2, random_state=42)

# Scale the features using StandardScaler
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)  # Use transform for test set, not fit_transform

# Train the linear regression model
model = LinearRegression()
model.fit(X_train_scaled, Y_train)

# Predict ratings for the test set
predicted_Y = model.predict(X_test_scaled)


# # Question 8 :: Évaluez les performances du modèle et comparez-les avec le modèle utilisant tous les attributs.

#  Évaluez les performances du modèle
mae = mean_absolute_error(Y_test, predicted_Y)
mse = mean_squared_error(Y_test, predicted_Y)
mape = mean_absolute_percentage_error(Y_test, predicted_Y)

print("Mean Absolute Error:", mae)
print("Mean Square Error:", mse)
print("Mean Absolute Percentage Error:", mape)

# comparez-les avec le modèle utilisant tous les attributs.

# Construction du modèle avec tous les attributs
X_all = df[["userId", "movieId", "timestamp"]]
Y_all = df["rating"]

X_train_all, X_test_all, Y_train_all, Y_test_all = train_test_split(X_all, Y_all, test_size=0.2, random_state=42)

scaler_all = StandardScaler()
X_train_scaled_all = scaler_all.fit_transform(X_train_all)
X_test_scaled_all = scaler_all.transform(X_test_all)

model_all = LinearRegression()
model_all.fit(X_train_scaled_all, Y_train_all)

predicted_Y_all = model_all.predict(X_test_scaled_all)

# Évaluez les performances du modèle utilisant tous les attributs
mae_all = mean_absolute_error(Y_test_all, predicted_Y_all)
mse_all = mean_squared_error(Y_test_all, predicted_Y_all)
mape_all = mean_absolute_percentage_error(Y_test_all, predicted_Y_all)

print("Mean Absolute Error (All Attributes):", mae_all)
print("Mean Square Error (All Attributes):", mse_all)
print("Mean Absolute Percentage Error (All Attributes):", mape_all)
print()

# Comparez avec le modèle utilisant uniquement l'attribut le plus dominant
print("Performance du modèle utilisant uniquement l'attribut le plus dominant (" + most_dominant_attribute + "):")
print("Mean Absolute Error (Most Dominant Attribute):", mae)
print("Mean Square Error (Most Dominant Attribute):", mse)
print("Mean Absolute Percentage Error (Most Dominant Attribute):", mape)

print("\nComparaison des performances:")
if mae < mae_all:
    print("mae < mae_all : L'erreur absolue moyenne est meilleure pour le modèle utilisant uniquement l'attribut le plus dominant.")
else:
    print("mae > mae_all : L'erreur absolue moyenne est meilleure pour le modèle utilisant tous les attributs.")

if mse < mse_all:
    print("mse < mse_all : L'erreur quadratique moyenne est meilleure pour le modèle utilisant uniquement l'attribut le plus dominant.")
else:
    print("mse > mse_all : L'erreur quadratique moyenne est meilleure pour le modèle utilisant tous les attributs.")

if mape < mape_all:
    print("mape < mape_all : L'erreur de pourcentage absolue moyenne est meilleure pour le modèle utilisant uniquement l'attribut le plus dominant.")
else:
    print("mape > mape_all : L'erreur de pourcentage absolue moyenne est meilleure pour le modèle utilisant tous les attributs.")