<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<?php

$data=[];
$data["SP04"]=array("San pham 4",4000,42);
$data["SP01"]=array("San pham 1",1000,12);
$data["SP02"]=array("San pham 2",2000,22);
$data["SP05"]=array("San pham 5",5000,52);
$data["SP03"]=array("San pham 3",3000,32);
//ksort($data);

?>
<table border="1" cellspacing="0">
    <tr>
        <th>STT</th>
        <th>Ma SP</th>
        <th>Ten SP</th>
        <th>Gia ban</th>
        <th>So luong</th>
    </tr>
    <?php 
    $stt=1;
    $tongSoLuong=0;
    foreach ($data as $masp=>  $dong) {
        $tongSoLuong+=$dong[2];
    ?>
    <tr>
        <td><?php echo $stt++;?></td>
        <td><?php echo $masp?></td>
        <td><?php echo $dong[0]?></td>
        <td><?php echo $dong[1]?></td>
        <td><?php echo $dong[2]?></td>
    </tr>
    <?php } ?>
    <tr>
        <td colspan="4">Tong so luong</td>
        <td><?php echo $tongSoLuong ?></td>
    </tr>
</table> 
</body>
</html>


