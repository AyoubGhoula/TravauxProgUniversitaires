
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Annuaire - Menu Principal</title>
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
            padding: 40px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }
        .menu-btn {
            display: block;
            width: 100%;
            padding: 15px;
            margin: 15px 0;
            background-color: #4CAF50;
            color: white;
            text-align: center;
            text-decoration: none;
            border-radius: 5px;
            font-size: 18px;
            transition: background-color 0.3s;
        }
        .menu-btn:hover {
            background-color: #45a049;
        }
        .menu-btn:nth-child(3) {
            background-color: #008CBA;
        }
        .menu-btn:nth-child(3):hover {
            background-color: #007399;
        }
        .menu-btn:nth-child(4) {
            background-color: #f44336;
        }
        .menu-btn:nth-child(4):hover {
            background-color: #da190b;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>📖 Annuaire - Menu Principal</h1>
        <a href="<%= request.getContextPath() %>/AnnuaireServlet/Ajout" class="menu-btn">➕ Ajouter une personne</a>
        <a href="<%= request.getContextPath() %>/AnnuaireServlet/Recherche" class="menu-btn">🔍 Rechercher une personne</a>
    </div>
</body>
</html>
