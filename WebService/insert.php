<?php
require "dbCon.php";

$hoten=$_POST['hotenSV'];
$namsinh=$_POST['namsinhSV'];
$diachi=$_POST['diachiSV'];

$query="INSERT INTO thongtinsinhvien VALUES(null,'$hoten','$namsinh','$diachi')";
if(mysqli_query($connect,$query)){
	echo "Success";
}else
{
	echo "Error";
}
?>	