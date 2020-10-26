package objects;

import exceptions.DataNotInvalid;

public class Sach {
    private int ma;
    private String ten;
    private String chuyenNganh;
    private double giaBan;

    public Sach() {
    }

    public Sach(int ma, String ten, String chuyenNganh, double giaBan) throws DataNotInvalid {
        this.ma = ma;
        this.ten = ten;
        this.chuyenNganh = chuyenNganh;
        this.giaBan = giaBan;
        if (checkAll()==false) throw new DataNotInvalid();
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + chuyenNganh + " " + giaBan;
    }

    private boolean checkMa() {
        if (ma >= 1000 && ma <= 9999) return true;
        return false;
    }

    private boolean checkTen() {
        if (ten.length() > 0) return true;
        return false;
    }

    private boolean checkChuyenNganh(){
        if (chuyenNganh.length()>0) return true;
        return false;
    }

    private boolean checkGia() {
        return giaBan > 0;
    }

    private boolean checkAll() {
        if (checkMa() && checkGia() && checkChuyenNganh() && checkTen()) return true;
        return false;
    }
}
