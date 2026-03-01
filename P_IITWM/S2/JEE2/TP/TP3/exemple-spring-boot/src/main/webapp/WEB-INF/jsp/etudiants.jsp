<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Liste des étudiants</title>
</head>
<body>

<h2>Liste des étudiants</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Nom</th>
        <th>Prénom</th>
        <th>Email</th>
    </tr>

    <c:forEach var="e" items="${etudiants}">
        <tr>
            <td>${e.id}</td>
            <td>${e.nom}</td>
            <td>${e.prenom}</td>
            <td>${e.email}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
