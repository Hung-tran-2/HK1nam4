<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        .bcc-box
        {
            width: 120px;
            height: 200px;
            background-color: #ccc;
            border: thin solid #f00;
            margin: 5px;
            padding: 5px;
            float: left;
        }
    </style>
</head>
<body>
    
    <?php
    /*    for ($i=2; $i < 10; $i++) { 
    ?>
            <div class="bcc-box">
            <?php 
            for ($j=1; $j <= 10; $j++) { 
                echo "$ x $j = ",$i*$j,"<br>";
            }
            ?>
            </div>
    <?php    } 
    */
    ?>
    <table border="1">
    
    <?php
    $dem=0;
    for ($i=2; $i < 20; $i++) {
        if($i%4==2)
            echo '<tr>';
    ?>
            <td>
                <?php
                for ($j=1; $j <= 10; $j++)  
                    echo "$i x $j = ",$i*$j,"<br>";
                ?>    
            </td>
    <?php 
        if($i%4==1)
            echo '</tr>';
    } ?>
        
    </table>
</body>
</html>