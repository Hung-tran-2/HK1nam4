<?php
	include "connect.php";
	$query = "SELECT * FROM nhanvien bh
INNER JOIN department tg ON bh.id_nv =  tg.id_pb" ;
	$data = mysqli_query($con,$query);
	$mangnv = array();
	
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangnv, new nhanvien(
			$row['id_nv'],
			$row['Name_nv'],
			$row['Birthday_nv'],
			$row['sex'],
			$row['name_pb'],
			$row['des_pb']
		));
	}
	echo json_encode($mangnv);
	class nhanvien{
		function __construct($id_nv,$tennv,$birthday,$gioitinh,$tenpb,$mota_pb){
			$this->id = $id_nv;
			$this->tennv = $tennv;
			$this->birthday = $birthday;			
			$this->gioitinh = $gioitinh;
			$this->tenpb = $tenpb;
			$this->mota_pb=$mota_pb;
		}		
	}
?>