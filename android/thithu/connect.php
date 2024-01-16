<?php
	//ini_set('display_errors', 'off');
	$hostname = "localhost";
	$username = "root";
	$password = "";
	$databasename = "nhanvien";

	$con = mysqli_connect($hostname, $username, $password, $databasename);
	$conn = new PDO("mysql:host=$hostname;dbname=$databasename", $username, $password);
    $conn->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
	mysqli_query($con, "SET NAMES 'utf8' ");
?>