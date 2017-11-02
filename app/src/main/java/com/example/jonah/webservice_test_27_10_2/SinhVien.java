package com.example.jonah.webservice_test_27_10_2;

import java.io.Serializable;

/**
 * Created by Jonah on 10/27/2017.
 */

public class SinhVien implements Serializable{
    private int id;
    private String hoten;
    private int namsinh;
    private String DiaChi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getNamsinh() {
        return namsinh;
    }

    public void setNamsinh(int namsinh) {
        this.namsinh = namsinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public SinhVien(int id, String hoten, int namsinh, String diaChi) {
        this.id = id;
        this.hoten = hoten;
        this.namsinh = namsinh;
        DiaChi = diaChi;
    }

}
