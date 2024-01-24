<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    session_start();
    if (isset($_SESSION['data']))
        $data = $_SESSION['data'];
    else
        $data = array();
    var_dump($data);
    if (isset($_POST['btnsubmit'])) //user click nut them
    {
        if (isset($data[$_POST['lstlop']])) //da co
        {
            $data[$_POST['lstlop']][$_POST['txt_ma']]=array($_POST['txt_ten']);
        } else {
            $data[$_POST['lstlop']] = array($_POST['txt_ma'] => array($_POST['txt_ten']));
        }
    }
    $_SESSION['data']=$data;
    ?>
    <h1>QUAN LY DS SV CAC LOP</h1>
    <form action="form.php" method="post">
        <h2>Them SV vao lop</h2>
        <select name="lstlop">
            <option value="D20_TH01">D20_TH01</option>
            <option value="D20_TH02">D20_TH02</option>
            <option value="D20_TH03">D20_TH03</option>
        </select>
        <br>
        Ma SV: <input type="text" name="txt_ma">
        <br>
        Ten SV: <input type="text" name="txt_ten">
        <br>
        <input type="submit" value="Them" name="btnsubmit">
    </form>
    <br>
    <select name="lop" id="lop" onchange="loc()">
        <option value="all">Chon lop de loc</option>
        <?php
            $malops=array_keys($data);
            foreach ($malops as $ml) {
                if(isset($_GET['malop']))
                    if($_GET['malop']==$ml)
                        echo "<option value='",$ml,"' selected>",$ml,"</option>";
                    else
                        echo "<option value='",$ml,"'>",$ml,"</option>";
                else
                    echo "<option value='",$ml,"'>",$ml,"</option>";
            }
        ?>
    </select>
    <table border="1" cellspacing="0" cellpadding="5">
        <tr>
            <th>Ma SV</th>
            <th>Ten SV</th>
            <th>Lop</th>
        </tr>
    <?php
    if(isset($_GET['malop']) && $_GET['malop']!='all')//loc
    {
        $dssv=$data[$_GET['malop']];
        foreach ($dssv as $masv => $ttsv) {
            echo "<tr><td>",$masv,"</td><td>",$ttsv[0],"</td><td>",$_GET['malop'],"</td><tr>";
        }
    }else
    foreach ($data as $malop => $dssv) {
        foreach ($dssv as $masv => $ttsv) {
            echo "<tr><td>",$masv,"</td><td>",$ttsv[0],"</td><td>",$malop,"</td><tr>";
        }
    }
    ?>
    </table>
<script>
    function loc()
    {
        location.href="form.php?malop="+document.getElementById('lop').value;
    }
</script>
</body>
</html>