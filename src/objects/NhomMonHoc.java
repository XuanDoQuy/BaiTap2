package objects;

import java.util.ArrayList;

public class NhomMonHoc {
    private String ten;
    private ArrayList<MonHoc> dsMonHoc;

    public NhomMonHoc(String ten) {
        this.ten = ten;
        dsMonHoc = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public ArrayList<MonHoc> getDsMonHoc() {
        return dsMonHoc;
    }
}
