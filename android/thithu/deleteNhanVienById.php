<?php
	require_once('connect.php');
	mysqli_set_charset($con,'utf8');
	/** Array for JSON response*/
	$response = array();
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$id_nv = $_POST['id_nv'];	
				$data = array($id_nv); 
				$stmta = $conn->prepare("delete from nhanvien where id_nv = ?");
				//$stmta->execute($data);
				
				try {
					$conn->beginTransaction();
					$stmta->execute($data);
					$conn->commit();
				} catch(PDOExecption $e) {
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