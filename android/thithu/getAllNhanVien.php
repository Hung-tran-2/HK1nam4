<?php
	include "connect.php";
	$query = "SELECT * FROM nhanvien" ;
	$data = mysqli_query($con,$query);
	$mangnv = array();
	
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangnv, new nhanvien(
			$row['id_nv'],
			$row['Name_nv'],
			$row['Birthday_nv'],
			$row['sex']
			
		));
	}
	echo json_encode($mangnv);
	class nhanvien{
		public function __construct($id_nv,$tennv,$birthday,$gioitinh){
			$this->id = $id_nv;
			$this->tennv = $tennv;
			$this->birthday = $birthday;			
			$this->gioitinh = $gioitinh;
		}		
	}
?>