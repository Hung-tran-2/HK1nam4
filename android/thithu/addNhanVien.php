<?php
	require_once('connect.php');
	mysqli_set_charset($con,'utf8');
	/** Array for JSON response*/
	$response = array();
	if($_SERVER['REQUEST_METHOD'] == 'POST'){
		$tennv = $_POST['ten_nv'];
		
		$ngaysinh = $_POST['ngaysinh'];
		
		$sex = $_POST['sex'];
		
		$department = $_POST['id_pb'];			
				$data = array($tennv, $ngaysinh, $sex, $department); 
				$stmta = $conn->prepare("INSERT INTO nhanvien (Name_nv, Birthday_nv, sex,Department_nv) VALUES (?,?,?,?)");
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