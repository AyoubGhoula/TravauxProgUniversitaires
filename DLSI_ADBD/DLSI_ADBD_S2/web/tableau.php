<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $tab=["red","green"];
    $i=rand(0,1);
    $color=$tab[$i];
    switch ($color) {
        case "red":
            echo "hello";
            break;
        case "green":
            echo "welcome";
            break;
    }

    ?>
</body>
</html>