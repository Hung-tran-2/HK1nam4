<?php
	require_once('connect.php');
	mysqli_set_charset($con,'utf8');
	/** Array for JSON response*/
	$response = array();
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$id_pb = $_POST['id_pb'];	
				$data = array($id_pb); 
				$stmta = $conn->prepare("delete from department where id_pb = ?");
				//$stmta->execute($data);
				
				try {
					$conn->beginTransaction();
					$stmta->execute($data);
					$conn->commit();
				} catch(RuntimeException $e) {
					$response["success"] = 0;
					$response["message"] = "Xóa thất bại!";
					echo json_encode($response);
					return;
				}
		$response["success"] = 1;
		$response["message"] = "Xóa thành công!";
		echo json_encode($response);
	}
?>