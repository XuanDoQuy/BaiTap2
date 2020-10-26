package objects;

import exceptions.DataNotInvalid;

public class MatHang {
    private int maHang;
    private String ten;
    private String nhom;
    private double giaBan;

    public MatHang() {
    }

    public MatHang(int maHang, String ten, String nhom, double giaBan) throws DataNotInvalid {
        this.maHang = maHang;
        this.ten = ten;
        this.nhom = nhom;
        this.giaBan = giaBan;
        if (checkAll() == false) throw new DataNotInvalid();
    }

    public int getMaHang() {
        return maHang;
    }

    public void setMaHang(int maHang) {
        this.maHang = maHang;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getNhom() {
        return nhom;
    }

    public void setNhom(String nhom) {
        this.nhom = nhom;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public String toString() {
        return maHang + " " + ten + " " + nhom + " " + giaBan;
    }

    private boolean checkMa() {
        if (maHang >= 1000 && maHang <= 9999) return true;
        return false;
    }

    private boolean checkTen() {
        if (ten.length() > 0) return true;
        return false;
    }

    private boolean checkNhom() {
        if (nhom.equals("tieu dung") || nhom.equals("thoi trang") || nhom.equals("dien tu")) return true;
        return false;
    }

    private boolean checkGia() {
        return giaBan > 0;
    }

    private boolean checkAll() {
        if (checkMa() && checkGia() && checkNhom() && checkTen()) return true;
        return false;
    }
}
