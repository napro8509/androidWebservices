<?php

require "dbCon.php";

$query="SELECT * FROM thongtinsinhvien";

$data =mysqli_query($connect,$query);

class SinhVien {
		function SinhVien($id,$hoten,$namsinh,$diachi){
			$this->Id=$id;
			$this->Hoten=$hoten;
			$this->Namsinh=$namsinh;
			$this->Diachi=$diachi;
		}
	}
// Tạo mảng 
	$mangSV=array();
// 3.Thêm phần tử vào mảng

while($row=mysqli_fetch_assoc($data)){
	array_push($mangSV, new SinhVien($row['id'],$row['hoten'],$row['namsinh'],$row['diachi']));
	
}
	echo json_encode($mangSV);

?>