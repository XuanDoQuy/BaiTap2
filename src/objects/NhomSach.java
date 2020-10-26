package objects;

import java.util.ArrayList;

public class NhomSach {
    private String ten;
    private ArrayList<Sach> dsSach;

    public NhomSach(String ten) {
        this.ten = ten;
        dsSach = new ArrayList<>();
    }

    public String getTen() {
        return ten;
    }

    public ArrayList<Sach> getDsSach() {
        return dsSach;
    }
}
