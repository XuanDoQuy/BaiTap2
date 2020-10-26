package objects;

import utils.Helper;

import java.util.Scanner;

public class PhanSo {
    private int ts;
    private int ms;

    public PhanSo() {
        this.ts = 0;
        this.ms = 1;
    }

    public PhanSo(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }

    public PhanSo cong(PhanSo ps2) {
        return new PhanSo(this.ts * ps2.ms + this.ms * ps2.ts, this.ms * ps2.ms).toiGian();
    }

    public PhanSo tru(PhanSo ps2) {
        return new PhanSo(this.ts * ps2.ms - this.ms * ps2.ts, this.ms * ps2.ms).toiGian();
    }

    public PhanSo nhan(PhanSo ps2) {
        return new PhanSo(this.ts * ps2.ts, this.ms * ps2.ms).toiGian();
    }

    public PhanSo chia(PhanSo ps2) {
        return new PhanSo(this.ts * ps2.ms, this.ms * ps2.ts).toiGian();
    }

    public PhanSo toiGian() {
        int x = Helper.UCLN(Math.abs(ts), Math.abs(ms));
        return new PhanSo(ts / x, ms / x);
    }

    public PhanSo nghichDao() {
        return new PhanSo(ms, ts);
    }

    public PhanSo doiDau() {
        return new PhanSo(-ts, ms);
    }

    public boolean bangNhau(PhanSo ps2) {
        PhanSo sub = this.tru(ps2);
        if (sub.ts == 0) return true;
        else return false;
    }

    public boolean lonHon(PhanSo ps2) {
        PhanSo sub = this.tru(ps2);
        if (sub.ts * sub.ms > 0) return true;
        else return false;
    }

    public boolean nhoHon(PhanSo ps2){
        PhanSo sub = this.tru(ps2);
        if (sub.ts * sub.ms < 0) return true;
        else return false;
    }

    public void hien(){
        System.out.println(ts+"/"+ms);
    }

    public void nhap(Scanner sc){
        ts = sc.nextInt();
        ms = sc.nextInt();
    }
}
