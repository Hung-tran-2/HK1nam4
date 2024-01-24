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
    $data['SV1']=array('Nguyen van A',9);
    $data['SV2']=array('Nguyen van B',6);
    $data['SV3']=array('Nguyen van V',4);

  ?>
  <table border="1" cellspacing="0" cellpadding="5">
    <tr>
        <th>MA SV</th>
        <th>Ho ten</th>
        <th>Diem</th>
        <th>Ghi chu</th>
    </tr>
    <?php
        foreach ($data as $masv => $sv) {
            if($sv[1]<5)
                echo "<tr bgcolor='red'>";
            else
                echo "<tr>";
            echo "<td>$masv</td><td>$sv[0]</td><td>$sv[1]</td>";
            if($sv[1]<5)
                echo '<td>rot</td>';
            else    
                echo '<td>&nbsp;</td>';
            echo "</tr>";
        }
    ?>
  </table>
</body>
</html>