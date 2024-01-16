<?php
	require_once('connect.php');
	mysqli_set_charset($con,'utf8');
	/** Array for JSON response*/
	$response = array();
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$tenpb = $_POST['tenpb'];
		
		$description = $_POST['description'];
		
		
		
			
				$data = array($tenpb, $description); 
				$stmta = $conn->prepare("INSERT INTO department (name_pb, des_pb) VALUES (?,?)");
				//$stmta->execute($data);
				
				try {
					$conn->beginTransaction();
					$stmta->execute($data);
					
					$response["id"] = $conn->lastInsertId();
					$response["success"] = 1;
					$response["message"] = "Thêm thành công!";
					$conn->commit();
				} catch(PDOExecption $e) {
					$response["success"] = 0;
					$response["message"] = "Thêm thất bại!";
					echo json_encode($e);
				}	
		echo json_encode($response);
	}
?>