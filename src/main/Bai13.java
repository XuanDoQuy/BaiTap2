package main;

import objects.PhanSo;

import java.util.Scanner;

public class Bai13 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        PhanSo p1 = new PhanSo(),p2 = new PhanSo();
        System.out.println("Nhap phan so thu 1:");
        p1.nhap(sc);
        System.out.println("Nhap phan so thu 2: ");
        p2.nhap(sc);
        System.out.println("Tong: ");
        p1.cong(p2).hien();
        System.out.println("Tru: ");
        p1.tru(p2).hien();
        System.out.println("Nhan: ");
        p1.nhan(p2).hien();
        System.out.println("Chia: ");
        p1.chia(p2).hien();
        System.out.println("Phan so 1 bang phan so 2: "+p1.bangNhau(p2));
        System.out.println("Phan so 1 lon hon phan so 2: "+p1.lonHon(p2));
        System.out.println("Phan so 1 nho hon phan so 2: "+p1.nhoHon(p2));
    }
}
