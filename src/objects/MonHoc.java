package objects;

import exceptions.DataNotInvalid;

public class MonHoc {
    private int ma;
    private String ten;
    private String nhomMh;
    private int soTinChi;

    public MonHoc() {
    }

    public MonHoc(int ma, String ten, String nhomMh, int soTinChi) throws DataNotInvalid {
        this.ma = ma;
        this.ten = ten;
        this.nhomMh = nhomMh;
        this.soTinChi = soTinChi;
        if (checkAll()==false) throw new DataNotInvalid();
    }

    public int getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }

    public String getNhomMh() {
        return nhomMh;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    @Override
    public String toString() {
        return ma + " " + ten + " " + nhomMh + " " + soTinChi;
    }

    private boolean checkMa() {
        if (ma >= 1000 && ma <= 9999) return true;
        return false;
    }

    private boolean checkTen() {
        if (ten.length() > 0) return true;
        return false;
    }

    private boolean checkNhom() {
        if (nhomMh.equals("co ban") || nhomMh.equals("co so nganh") || nhomMh.equals("chuyen nganh")||nhomMh.equals("ki nang mem")) return true;
        return false;
    }

    private boolean checkTin() {
        if (soTinChi>0&&soTinChi<7) return true;
        else return false;
    }

    private boolean checkAll() {
        if (checkMa() && checkTin() && checkNhom() && checkTen()) return true;
        return false;
    }
}
