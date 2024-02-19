<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $cars=array(array("Volvo",22,18),
    array("bmw",15,13),
    array("Saab",5,2),
    array("land rover",17,15));
    foreach($cars as $car){
        echo "$car[0] : In stock : $car[1] , sold: $car[2] <br>";
    }
    ?>
</body>
</html>