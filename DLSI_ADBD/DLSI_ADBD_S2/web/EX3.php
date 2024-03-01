<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background-image: url("image.jpg");
            height: 100px;
            background-position: auto;
        }

        form {
            background-color: orange;
            border-radius: 30px;
            font-size: x-large;
            padding: 30px;
            margin: 30px;
        }

        h1 {
            color: orange;
            text-align: center;
            font-family: cursive;
        }
        .text{
                width: 300px;
                height: 30px;
                border-radius: 9px;
            }

        .button {
            text-align: center;
        }

        .button button {
            height: 30px;
            width: 70px;
            border-radius: 7px;
        }
    </style>
</head>
<body>
<h1>Inscriptions</h1>
<form method="post" action="inscription.php">
    <table>
        <tr>
            <td>Prénom:</td>
            <td><input type="text" name="prenom" class="text"></td>
        </tr>
        <tr>
            <td>Mot de passe :</td>
            <td><input type="text" name="motdepasse" class="text"></td>
        </tr>
        <tr>
            <td>Association :</td>
            <td>
                <select name="associa" class="text">
                    <option value="associationX">associationX</option>
                    <option value="associationY">associationY</option>
                    <option value="associationZ">associationZ</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>Disponibilités pour la semaine du 22 juin :</td>
            <td>
                <input type="checkbox" name="Lundi" value="lundi">Lundi
                <input type="checkbox" name="Mardi" value="mardi">mardi
                <input type="checkbox" name="Merctedi" value="mercredi">Mercredi
                <input type="checkbox" name="Jeudi" value="jeudi">Jeudi
                <input type="checkbox" name="Vendredi" value="vendredi">Vendredi
            </td>
        </tr>
        <tr>
            <td>Contribution :</td>
            <td>
                <input type="radio" name="entée" id="entee" value="Entrée">
                <label for="entee">Entrée</label>
                <input type="radio" name="entée" id="Plat" value="Plat">
                <label for="Plat">Plat</label>
                <input type="radio" name="entee" id="Dessert" value="Dessert">
                <label for="Dessert">Dessert</label>
            </td>
        </tr>
        <tr>
            <td>Commentaires :</td>
            <td><textarea name="commentaires" rows="6" cols="50"></textarea></td>
        </tr>
    </table>
    <div class="button">
        <button type="submit">S'inscrire!</button>
        <button type="reset">Annuler</button>
    </div>
</form>
</body>
</html>
