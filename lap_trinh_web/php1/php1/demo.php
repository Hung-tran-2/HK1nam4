<?php
include "qlsv.php";
session_start();
var_dump($_SESSION);
?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <form action="demo.php" method="post">
        Lop: <select name="lop">
            <option value="D20_TH01">D20_TH01</option>
            <option value="D21_TH01">D21_TH01</option>
            <option value="D22_TH01">D22_TH01</option>
            <option value="D23_TH01">D23_TH01</option>
        </select>
        <br>
        Ma SV: <input type="text" name="masv"><br>
        Ten SV: <input type="text" name="tensv"><br>
        <input type="submit" value="Them" name="btnSubmit">
    </form>
    <?php
    //Hien thi ds SV co trong moi lop hoc
    if(!isset($_SESSION['dssv']))
        $_SESSION['dssv']=array();
    $dssv = $_SESSION['dssv'];
    // $dssv['D20_TH01'] = array(
    //     array("SV1", "Sinh vien 1"),
    //     array("SV2", "Sinh vien 2")
    // );
    // $dssv['D21_TH01'] = array(
    //     array("SV3", "Sinh vien 3"),
    //     array("SV4", "Sinh vien 4")
    // );

    if (isset($_POST['btnSubmit'])) //khi co nhan submit
    {
        if ($_POST['masv'] != "" && $_POST['tensv'] != "")
            if (them($dssv, $_POST['masv'], $_POST['tensv'], $_POST['lop']))
            {    echo "Them thanh cong";
                $_SESSION['dssv']=$dssv;
            }else
                echo "Them khong thanh cong";
    }
    ?>
    <h2>DANH SACH SINH VIEN CAC LOP</h2>
    <select name="chonlop">
        <option value="">Hay chon lop muon xem ds</option>
        <?php
        foreach ($dssv as $malop => $value) {
            echo '<option value="', $malop, '">', $malop, '</option>';
        }
        ?>


    </select>
    <table border="1" cellspacing="0">
        <tr>
            <th>Ma sv</th>
            <th>Ten sv</th>
        </tr>
        <?php
        foreach ($dssv as $malop => $lop) {
            foreach ($lop as $sv) {
        ?>
                <tr>
                    <td><?php echo $sv[0] ?></td>
                    <td><?php echo $sv[1] ?></td>
                </tr>
        <?php }
        } ?>
    </table>
</body>

</html>