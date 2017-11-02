<?php

require("dbCon.php");

$id=$_POST['idSV'];

$query="DELETE FROM thongtinsinhvien WHERE id='$id'";
if(mysqli_query($connect,$query))
{
	echo "success";
}
else{
	echo "error";
}
?>