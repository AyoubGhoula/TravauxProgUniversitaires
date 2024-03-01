
<?php
if ($_SERVER["REQUEST_METHOD"]=="POST"){
    if (empty($_POST["prenom"])|| empty($_POST["motdepasse"])|| empty($_POST["associa"]) || empty($_POST["entée"])|| empty($_POST["commentaires"])|| (empty($_POST["Lundi"])&&empty($_POST["Mardi"])&&empty($_POST["Vendredi"])&&empty($_POST["Jeudi"])&&empty($_POST["Merctedi"]))) {
        echo"<h1 style='color: red;'>erruer il y a un ou plusieure information vide!! <h1>";
    }
    else {
        $dis="";
        $days=["Merctedi","Jeudi","Vendredi","Mardi","Lundi"];
        foreach($days as $day) {
            if (empty($_POST[$day])==false) {
                $dis.=$_POST[$day]." | ";
        }}
        echo"<h1 style='margin: 30px;'> Prénom :".$_POST["prenom"]."<br><br> Mot de passe : ".$_POST["motdepasse"]."<br> <br>Association :".$_POST["associa"]."<br> <br> Disponibilités pour la semaine du 22 juin :".substr($dis,0,strlen($dis)-2)."<br> <br>Contribution :".$_POST["entée"]. "<br> <br>Commentaires :".$_POST["commentaires"]."</h1>";
    }

}
?>  