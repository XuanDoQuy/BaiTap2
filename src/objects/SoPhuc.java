package objects;

import jdk.nashorn.internal.parser.JSONParser;

import java.util.Scanner;

public class SoPhuc {
    private float a;
    private float b;

    public SoPhuc() {
        this.a = 0;
        this.b = 0;
    }

    public SoPhuc(float thuc, float ao) {
        this.a = thuc;
        this.b = ao;
    }


    public SoPhuc cong(SoPhuc sp2) {
        return new SoPhuc(this.a + sp2.a, this.b + sp2.b);
    }

    public SoPhuc tru(SoPhuc sp2) {
        return new SoPhuc(this.a - sp2.a, this.b - sp2.b);
    }

    public SoPhuc nhan(SoPhuc sp2) {
        return new SoPhuc(this.a * sp2.a - this.b * sp2.b, this.a * sp2.b + this.b * sp2.a);
    }

    public SoPhuc chia(SoPhuc sp2) {
        return new SoPhuc((this.a * sp2.a + this.b * sp2.b) / (float) (Math.pow(sp2.a, 2) + Math.pow(sp2.b, 2))
                , (this.b * sp2.a - this.a * sp2.b) / (float) (Math.pow(sp2.a, 2) + Math.pow(sp2.b, 2)));
    }

    public SoPhuc nghichDao() {
        return new SoPhuc(a / (float) (Math.pow(a, 2) + Math.pow(b, 2)), -b / (float) (Math.pow(a, 2) + Math.pow(b, 2)));
    }

    public boolean bangNhau(SoPhuc sp2) {
        if (this.a == sp2.a && this.b == sp2.b) return true;
        else return false;
    }

    public boolean lonHon(SoPhuc sp2) {
        if ((Math.pow(this.a, 2) + Math.pow(this.b, 2) > (Math.pow(sp2.a, 2) + Math.pow(sp2.b, 2)))) return true;
        else return false;
    }

    public boolean nhoHon(SoPhuc sp2) {
        if ((Math.pow(this.a, 2) + Math.pow(this.b, 2) < (Math.pow(sp2.a, 2) + Math.pow(sp2.b, 2)))) return true;
        else return false;
    }

    public void hien() {
        if (b < 0) {
            System.out.println(a + "-j" + Math.abs(b));
        } else if (b > 0) {
            System.out.println(a + "+j" + b);
        } else {
            System.out.println(a);
        }
    }

    public void nhap(Scanner sc) {
        a = sc.nextInt();
        b = sc.nextInt();
    }
}
