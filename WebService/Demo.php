<?php
	
// Dấu + là phép cộng
// Dấu . là phép nối chuỗi
// Dùng $ để tạo biến
	class SinhVien {
		function SinhVien($hoten,$namsinh,$diachi){
			$this->Hoten=$hoten;
			$this->Namsinh=$namsinh;
			$this->Diachi=$diachi;
		}
	}
// Tạo mảng 
	$mangSV=array();
// 3.Thêm phần tử vào mảng
	array_push($mangSV, new SinhVien("Le Gio Na",1999,"Ha Noi"));
	array_push($mangSV, new SinhVien("Le An",1998,"Ha Nam"));
	array_push($mangSV, new SinhVien("Le Dung",1997,"Ha Bac"));
	echo json_encode($mangSV);

?>