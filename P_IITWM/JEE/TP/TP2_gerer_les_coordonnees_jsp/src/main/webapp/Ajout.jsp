
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Personne</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            max-width: 600px;
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
        input[type="text"], input[type="email"] {
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
        .btn-submit {
            background-color: #4CAF50;
            color: white;
        }
        .btn-submit:hover {
            background-color: #45a049;
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
        .button-group {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>➕ Ajouter une Personne</h1>
        
        <% 
            String msg = (String) request.getAttribute("msg");
            Boolean success = (Boolean) request.getAttribute("success");
            
            if (msg != null && !msg.isEmpty()) {
                if (success != null && success) {
        %>
                    <div class="message success"><%= msg %></div>
        <%      } else { %>
                    <div class="message error"><%= msg %></div>
        <%      }
            }
        %>
        
        <form action="<%= request.getContextPath() %>/AnnuaireServlet/Ajout" method="post">
            <div class="form-group">
                <label for="nom">Nom * :</label>
                <input type="text" id="nom" name="nom" required placeholder="Entrez le nom">
            </div>
            
            <div class="form-group">
                <label for="adresse">Adresse * :</label>
                <input type="text" id="adresse" name="adresse" required placeholder="Entrez l'adresse">
            </div>
            
            <div class="form-group">
                <label for="tel">Téléphone * :</label>
                <input type="text" id="tel" name="tel" required placeholder="Entrez le numéro de téléphone">
            </div>
            
            <div class="form-group">
                <label for="email">Email * :</label>
                <input type="email" id="email" name="email" required placeholder="Entrez l'email">
            </div>
            
            <div class="button-group">
                <button type="submit" class="btn btn-submit">Ajouter</button>
                <button type="button" class="btn btn-back" onclick="location.href='<%= request.getContextPath() %>/AnnuaireServlet/Menu'">Retour</button>
            </div>
        </form>
    </div>
</body>
</html>
