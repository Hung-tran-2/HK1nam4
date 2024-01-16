<?php

	
	include "connect.php";
	class nhanvien{
		function __construct($id_nv,$tennv,$birthday,$gioitinh){
			$this->id = $id_nv;
			$this->tennv = $tennv;
			$this->birthday = $birthday;			
			$this->gioitinh = $gioitinh;
		}		
	}
	if($_SERVER['REQUEST_METHOD'] == 'GET'){
		
		
		$id_pb = $_GET['id_pb'];
		$stmt = $conn->prepare("SELECT * FROM nhanvien where Department_nv = :id_pb");
		$stmt->bindParam(":id_pb", $id_pb);
		$data = $stmt->execute();
		$mangnv = array();
		$nhanvienlist = $stmt->fetchAll(PDO::FETCH_ASSOC);
		foreach ($nhanvienlist as $row => $link) {
			array_push($mangnv, new nhanvien(
			$link['id_nv'],
			$link['Name_nv'],
			$link['Birthday_nv'],
			$link['sex']
			
		));
		}
	echo json_encode($mangnv);
	
	}
	
?>