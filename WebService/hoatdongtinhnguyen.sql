-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 04, 2017 lúc 11:18 AM
-- Phiên bản máy phục vụ: 10.1.28-MariaDB
-- Phiên bản PHP: 7.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `hoatdongtinhnguyen`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hoatdong`
--

CREATE TABLE `hoatdong` (
  `mahoatdong` varchar(255) NOT NULL,
  `tenhoatdong` varchar(255) NOT NULL,
  `matruong` varchar(255) NOT NULL,
  `ngaybatdau` date NOT NULL,
  `ngayketthuc` date NOT NULL,
  `diadiem` varchar(255) NOT NULL,
  `noidung` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `hoatdong`
--

INSERT INTO `hoatdong` (`mahoatdong`, `tenhoatdong`, `matruong`, `ngaybatdau`, `ngayketthuc`, `diadiem`, `noidung`) VALUES
('UEL001', 'Mùa hè xanh', 'UEL', '2017-11-07', '2017-11-10', 'Hồ Đá', 'Giải bơi vô địch hồ đá mở rộng'),
('UIT001', 'Tình nguyện xanh', 'UIT', '2017-11-20', '2017-11-30', 'Làng đại học', 'Ra quân dọn dẹp vệ sinh đường phố');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `truong_hinhanh`
--

CREATE TABLE `truong_hinhanh` (
  `matruong` varchar(250) NOT NULL,
  `tentruong` varchar(250) NOT NULL,
  `hinh` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `truong_hinhanh`
--

INSERT INTO `truong_hinhanh` (`matruong`, `tentruong`, `hinh`) VALUES
('UEL', 'Đại học kinh tế luật', 'http://www.iujobhub.com/wp-content/uploads/2014/10/logo-uel-BIG.png'),
('UIT', 'Đại học Công Nghệ Thông Tin TP-HCM', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbSNxKGmNcXYf5bk-io7u_WPPVEzjaV-zctQHMh0aTPi6_G22k');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `hoatdong`
--
ALTER TABLE `hoatdong`
  ADD PRIMARY KEY (`mahoatdong`(250));

--
-- Chỉ mục cho bảng `truong_hinhanh`
--
ALTER TABLE `truong_hinhanh`
  ADD PRIMARY KEY (`matruong`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
