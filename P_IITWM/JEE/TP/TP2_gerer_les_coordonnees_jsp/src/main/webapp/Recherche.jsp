<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Personne" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Rechercher une Personne</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #f5f5f5;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
        }
        .form-group {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 14px;
            box-sizing: border-box;
        }
        .btn {
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            margin-right: 10px;
        }
        .btn-search {
            background-color: #4CAF50;
            color: white;
        }
        .btn-search:hover {
            background-color: #45a049;
        }
        .btn-delete {
            background-color: #f44336;
            color: white;
        }
        .btn-delete:hover {
            background-color: #da190b;
        }
        .btn-back {
            background-color: #008CBA;
            color: white;
        }
        .btn-back:hover {
            background-color: #007399;
        }
        .message {
            padding: 15px;
            margin-bottom: 20px;
            border-radius: 5px;
        }
        .error {
            background-color: #ffebee;
            color: #c62828;
            border: 1px solid #ef5350;
        }
        .success {
            background-color: #e8f5e9;
            color: #2e7d32;
            border: 1px solid #66bb6a;
        }
        .result-card {
            background-color: #f9f9f9;
            padding: 20px;
            border-radius: 5px;
            margin-top: 20px;
            border: 1px solid #ddd;
        }
        .result-card h2 {
            margin-top: 0;
            color: #333;
        }
        .result-row {
            margin: 10px 0;
            padding: 8px;
            background-color: white;
            border-left: 3px solid #4CAF50;
        }
        .result-label {
            font-weight: bold;
            color: #555;
            display: inline-block;
            width: 100px;
        }
        .button-group {
            margin-top: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>🔍 Rechercher une Personne</h1>
        
        <% 
            // Check for messages in request scope first, then session
            String msg = (String) request.getAttribute("msg");
            Boolean success = (Boolean) request.getAttribute("success");
            
            if (msg == null) {
                msg = (String) session.getAttribute("msg");
                success = (Boolean) session.getAttribute("success");
                // Clear session attributes after reading
                session.removeAttribute("msg");
                session.removeAttribute("success");
            }
            
            Personne personne = (Personne) request.getAttribute("personne");
            
            if (msg != null) {
                if (success != null && success) {
        %>
                    <div class="message success"><%= msg %></div>
        <%      } else { %>
                    <div class="message error"><%= msg %></div>
        <%      }
            }
        %>
        
        <!-- Search Form -->
        <form action="<%= request.getContextPath() %>/AnnuaireServlet/Recherche" method="post">
            <div class="form-group">
                <label for="nom">Nom de la personne :</label>
                <input type="text" id="nom" name="nom" required placeholder="Entrez le nom à rechercher">
            </div>
            
            <div class="button-group">
                <button type="submit" class="btn btn-search">Rechercher</button>
                <button type="button" class="btn btn-back" onclick="location.href='<%= request.getContextPath() %>/AnnuaireServlet/Menu'">Retour au Menu</button>
            </div>
        </form>
        
        <!-- Display Result -->
        <% if (personne != null) { %>
            <div class="result-card">
                <h2>✅ Personne trouvée</h2>
                <div class="result-row">
                    <span class="result-label">Nom :</span>
                    <span><%= personne.getNom() %></span>
                </div>
                <div class="result-row">
                    <span class="result-label">Adresse :</span>
                    <span><%= personne.getAdresse() != null ? personne.getAdresse() : "N/A" %></span>
                </div>
                <div class="result-row">
                    <span class="result-label">Téléphone :</span>
                    <span><%= personne.getNumTel() != null ? personne.getNumTel() : "N/A" %></span>
                </div>
                <div class="result-row">
                    <span class="result-label">Email :</span>
                    <span><%= personne.getEmail() != null ? personne.getEmail() : "N/A" %></span>
                </div>
                
                <!-- Delete Form -->
                <div class="button-group">
                    <form action="<%= request.getContextPath() %>/AnnuaireServlet/Supprimer" method="post" 
                          onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer <%= personne.getNom() %> ?');">
                        <input type="hidden" name="nom" value="<%= personne.getNom() %>">
                        <button type="submit" class="btn btn-delete">🗑️ Supprimer cette personne</button>
                    </form>
                </div>
            </div>
        <% } %>
    </div>
</body>
</html>