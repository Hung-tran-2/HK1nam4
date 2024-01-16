<?php
	require_once('connect.php');

	if($_SERVER['REQUEST_METHOD'] == 'GET'){
		$response;
		$id_nv = $_GET['id_nv'];
		
		$name_nv = $_GET['name'];
		
		$birthdate = $_GET['birthday'];
		
		$sex = $_GET['sex'];
		
		$department = $_GET['id_pb'];			
				$data = array($name_nv, $birthdate, $sex, $department,$id_nv); 
				$stmta = $conn->prepare("UPDATE nhanvien SET Name_nv=?, Birthday_nv=?, sex=?,Department_nv=? WHERE id_nv=? ");
				//$stmta->execute($data);
				
				try {
					$conn->beginTransaction();
					$stmta->execute($data);
					$conn->commit();
				} catch( RuntimeException $e) {
					$response["success"] = 0;
					$response["message"] = "update thất bại!";
					echo json_encode($response);
					return;
				}
		$response["success"] = 1;
		$response["message"] = "update thanh cong";
		echo json_encode($response);
	}

?>