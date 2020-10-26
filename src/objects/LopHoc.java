package objects;

import java.util.ArrayList;

public class LopHoc {
    String ten;
    ArrayList<SinhVien> dssv;

    public LopHoc(String ten) {
        this.ten = ten;
        dssv = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public ArrayList<SinhVien> getDssv() {
        return dssv;
    }
}
