<!DOCTxPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <?php
    $x=rand(0,1000);
    $n=2;
    while ($n <=($x/2)){
        if ($x%$n==0){
            echo "$n, ";
        }
        $n++;
         
    }

    ?>
</body>
</html>