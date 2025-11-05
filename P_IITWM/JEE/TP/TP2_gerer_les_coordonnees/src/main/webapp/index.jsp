<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Gestion d'Annuaire</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Gestion d'Annuaire de Personnes</h1>
        
        <div class="menu">
            <div class="menu-item">
                <h2>Insérer une personne</h2>
                <p>Ajouter une nouvelle personne dans l'annuaire</p>
                <a href="inserer" class="btn btn-primary">Accéder</a>
            </div>
            
            <div class="menu-item">
                <h2> Rechercher une personne</h2>
                <p>Rechercher les coordonnées d'une personne</p>
                <a href="rechercher" class="btn btn-info">Accéder</a>
            </div>
            
            <div class="menu-item">
                <h2>Supprimer une personne</h2>
                <p>Supprimer une personne de l'annuaire</p>
                <a href="supprimer" class="btn btn-danger">Accéder</a>
            </div>
        </div>
    </div>
</body>
</html>