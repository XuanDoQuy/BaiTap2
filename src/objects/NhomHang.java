package objects;

import java.util.ArrayList;

public class NhomHang {
    private String ten;
    private ArrayList<MatHang> dssp;

    public NhomHang(String ten) {
        this.ten = ten;
        dssp = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public ArrayList<MatHang> getDssp() {
        return dssp;
    }
}
