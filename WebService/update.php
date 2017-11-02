<?php
require "dbCon.php";
$id=$_POST['idSV'] ;
$hoten=$_POST['hotenSV'] ;
$namsinh=$_POST['namsinhSV'] ;
$diachi=$_POST['diachiSV'] ;

$query= "UPDATE thongtinsinhvien SET hoten='$hoten',namsinh='$namsinh', diachi='$diachi' WHERE thongtinsinhvien.id='$id'";

if(mysqli_query($connect,$query)){
	echo "success";
}
else{
	echo "error\n";
	echo $query;
}
?>