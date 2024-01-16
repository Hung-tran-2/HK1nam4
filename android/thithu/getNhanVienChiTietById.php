<?php
	include "connect.php";
	
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
	
	if($_SERVER['REQUEST_METHOD'] == 'GET'){
		$query = "SELECT * FROM nhanvien bh
	INNER JOIN department tg ON bh.id_nv =  tg.id_pb where id_nv = ?" ;
		//$data = mysqli_query($con,$query);
		$mangnv = array();
		$id_nv = $_GET['id_nv'];
		$stmta = $conn->prepare($query);
		$data = array($id_nv); 
		$conn->beginTransaction();
		$stmta->execute($data);
		$nhanvien = $stmta->fetchAll(PDO::FETCH_ASSOC);
		foreach ($nhanvien as $row => $link) {
			array_push($mangnv, new nhanvien(
			$link['id_nv'],
			$link['Name_nv'],
			$link['Birthday_nv'],
			$link['sex'],
			$link['name_pb'],
			$link['des_pb']
		));
		}
		echo json_encode($mangnv);
		
	}
?>