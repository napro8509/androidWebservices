package com.example.jonah.webservice_test_27_10_2;

import java.text.DateFormat;

/**
 * Created by Jonah on 11/2/2017.
 */

public class TinhNguyen {
    private String mahoatdong;
    private String tenhoatdong;
    private String matruong;
    private String tentruong;
    private String ngaybatdau;
    private String ngayketthuc;
    private String diadiem;
    private String noidung;

    public String getMahoatdong() {
        return mahoatdong;
    }

    public void setMahoatdong(String mahoatdong) {
        this.mahoatdong = mahoatdong;
    }

    public String getTenhoatdong() {
        return tenhoatdong;
    }

    public void setTenhoatdong(String tenhoatdong) {
        this.tenhoatdong = tenhoatdong;
    }

    public String getMatruong() {
        return matruong;
    }

    public void setMatruong(String matruong) {
        this.matruong = matruong;
    }

    public String getTentruong() {
        return tentruong;
    }

    public void setTentruong(String tentruong) {
        this.tentruong = tentruong;
    }

    public String getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(String ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public String getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(String ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public TinhNguyen(String mahoatdong, String tenhoatdong, String matruong,String tentruong, String ngaybatdau, String ngayketthuc, String diadiem, String noidung) {
        this.mahoatdong = mahoatdong;
        this.tenhoatdong = tenhoatdong;
        this.matruong = matruong;
        this.tentruong=tentruong;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.diadiem = diadiem;
        this.noidung = noidung;
    }
}
