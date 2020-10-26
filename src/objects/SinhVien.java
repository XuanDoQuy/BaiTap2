package objects;

import exceptions.DataNotInvalid;

public class SinhVien {
    private int mSV;
    private String hoTen;
    private String lop;
    private String khoa;
    private double dtb;

    public SinhVien(int mSV, String hoTen, String lop, String khoa) {
        this.mSV = mSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.khoa = khoa;
    }

    public SinhVien() {

    }

    public SinhVien(int mSV, String hoTen, String lop, double dtb) throws DataNotInvalid {
        this.mSV = mSV;
        this.hoTen = hoTen;
        this.lop = lop;
        this.dtb = dtb;
        if (!DataInvalid()) throw new DataNotInvalid();
    }

    public int getmSV() {
        return mSV;
    }

    public void setmSV(int mSV) {
        this.mSV = mSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public double getDtb() {
        return dtb;
    }

    public void setDtb(double dtb) {
        this.dtb = dtb;
    }

    @Override
    public String toString() {
        return mSV + " " + hoTen + " " + lop + " " + dtb;
    }

    public String getInfo() {
        return mSV + " " + hoTen + " " + lop + " " + khoa;
    }

    private boolean DataInvalid() {
        if (checkMSV()&&checkName()&&checkDtb()&&checkLop()) return true;
        else return false;
    }

    private boolean checkMSV() {
        if (mSV >= 1000 && mSV <= 9999) return true;
        else return false;
    }

    private boolean checkName() {
        return hoTen.split(" ").length > 2;
    }

    private boolean checkLop() {
        if (lop.length() != 11) return false;
        if (!Character.isUpperCase(lop.charAt(0))) return false;
        if (!(Character.isDigit(lop.charAt(1)) && Character.isDigit(lop.charAt(2)))) return false;
        for (int i = 3; i < 7; i++) {
            if (!Character.isUpperCase(lop.charAt(i))) return false;
        }
        for (int i = 7; i < 9; i++) {
            if (!Character.isDigit(lop.charAt(i))) return false;
        }
        if (lop.charAt(9)!='-'&&lop.charAt(10)!='B') return false;
        return true;
    }

    private boolean checkDtb() {
        if (dtb >= 0 && dtb <= 10) return true;
        return false;
    }

}
