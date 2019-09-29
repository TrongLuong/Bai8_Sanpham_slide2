package com.example.bai8_sanpham_slide2;

import java.io.Serializable;

public class SanPham implements Serializable {
    private  String maSp;
    private  String tenSP;
    private  String nccSP;


    public  SanPham(){}
    public SanPham(String maSp, String tenSP, String nccSP) {
        this.maSp = maSp;
        this.tenSP = tenSP;
        this.nccSP = nccSP;
    }

    @Override
    public String toString() {
        return "SanPham{" +
                "maSp='" + maSp + '\'' +
                ", tenSP='" + tenSP + '\'' +
                ", nccSP='" + nccSP + '\'' +
                '}';
    }




    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getNccSP() {
        return nccSP;
    }

    public void setNccSP(String nccSP) {
        this.nccSP = nccSP;
    }
}
