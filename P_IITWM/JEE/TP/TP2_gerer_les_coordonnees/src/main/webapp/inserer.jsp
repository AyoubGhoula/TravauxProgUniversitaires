<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insérer une Personne</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="container">
        <h1>Insérer une Personne</h1>
        
        <% if (request.getAttribute("erreur") != null) { %>
            <div class="alert alert-error">
                <%= request.getAttribute("erreur") %>
            </div>
        <% } %>
        
        <% if (request.getAttribute("succes") != null) { %>
            <div class="alert alert-success">
                <%= request.getAttribute("succes") %>
            </div>
        <% } %>
        
        <form method="post" action="inserer" class="form">
            <div class="form-group">
                <label for="nom">Nom *</label>
                <input type="text" id="nom" name="nom" placeholder="Entrez le nom">
            </div>
            
            <div class="form-group">
                <label for="adresse">Adresse *</label>
                <input type="text" id="adresse" name="adresse" placeholder="Entrez l'adresse">
            </div>
            
            <div class="form-group">
                <label for="telephone">Numéro de Téléphone *</label>
                <input type="text" id="telephone" name="telephone" placeholder="Ex: 0612345678">
            </div>
            
            <div class="form-group">
                <label for="email">Adresse Email *</label>
                <input type="text" id="email" name="email" placeholder="exemple@email.com">
            </div>
            
            <div class="form-actions">
                <button type="submit" class="btn btn-primary">Ajouter</button>
                <a href="index.jsp" class="btn btn-secondary">Retour</a>
            </div>
        </form>
    </div>
</body>
</html>