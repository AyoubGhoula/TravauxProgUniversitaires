<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $etudiants=[
        "ali"=>["html"=>[12,15,14],"java"=>[10,18,13],"angular"=>[14,13.5,17]],
        "mohamed"=>["html"=>[13,18,15],"java"=>[9,7,3],"angular"=>[8,7.5,7]],
        "sami"=>["html"=>[17,18,20],"java"=>[14,18,15.5],"angular"=>[13,17.5,18]],
        ];
        $moy_gen=0;
    foreach($etudiants as $etudiant=>$matieres){
        
        echo "<h1>$etudiant</h1><br>";
        echo "<table border=\"1\">
        <tr>
        <th> matiare</th>
        <th> note tp</th>
        <th> note ds</th>
        <th> note examen </th>
        <th> moyenne </th></tr>";
        
        foreach($matieres as $matiere => $notes ){
            echo "<tr>";
            echo "<th>$matiere</th>";
            foreach($notes as $note){
                echo "<th>$note</th>";
            }
            $moyenne=($notes[0]+$notes[1]+$notes[2]*2)/4;
            $moy_gen+=$moyenne;
            echo "<th>".$moyenne."</th></tr>"; 
             
        }
        $moy_gen/=3;
        echo '<tr> <td colspan="3"> Moyenne generale</td>
                <th>'.$moy_gen."</th></tr>";
        $mention='';
        if ($moy_gen >= 0 && $moy_gen < 10) {
            $mention = "Insuffisant";
        } elseif ($moy_gen >= 10 && $moy_gen < 12) {
            $mention = "Passable";
        } elseif ($moy_gen >= 12 && $moy_gen < 14) {
            $mention = "Assez bien";
        } elseif ($moy_gen >= 14 && $moy_gen < 16) {
            $mention = "Bien";
        } elseif ($moy_gen >= 16 && $moy_gen <= 20) {
            $mention = "Très bien";
        }
        echo '<tr> <td colspan="3">Mention</td>
                <th>'.$mention.'</th></table>';

    }


    ?>
</body>
</html>