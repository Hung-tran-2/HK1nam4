<?php
	include "connect.php";
	$query = "SELECT * FROM department" ;
	$data = mysqli_query($con,$query);
	$mangpb = array();
	
	while ($row = mysqli_fetch_assoc($data)) {
		array_push($mangpb, new pb(
			$row['id_pb'],
			$row['name_pb'],
			$row['des_pb']
			
		));
	}
	echo json_encode($mangpb);
	class pb{
		public function __construct($id_pb,$ten_pb,$des){
			$this->id_pb = $id_pb;
			$this->ten_pb = $ten_pb;
			$this->des = $des;		
		}
			
	}
?>