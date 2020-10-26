package main;

import objects.PhanSo;
import objects.SoPhuc;

import java.lang.ref.SoftReference;
import java.util.Scanner;

public class Bai14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SoPhuc p1 = new SoPhuc(),p2 = new SoPhuc();
        System.out.println("Nhap so phuc thu 1:");
        p1.nhap(sc);
        System.out.println("Nhap so phuc thu 2: ");
        p2.nhap(sc);
        System.out.println("Tong: ");
        p1.cong(p2).hien();
        System.out.println("Hieu: ");
        p1.tru(p2).hien();
        System.out.println("Tich: ");
        p1.nhan(p2).hien();
        System.out.println("Thuong: ");
        p1.chia(p2).hien();
        System.out.println("Nghich dao so thu nhat: ");
        p1.nghichDao().hien();
        System.out.println("Nghich dao so thu hai: ");
        p2.nghichDao().hien();
        System.out.println("So phuc 1 bang so phuc 2: "+p1.bangNhau(p2));
        System.out.println("So phuc 1 lon hon so phuc 2: "+p1.lonHon(p2));
        System.out.println("So phuc 1 nho hon so phuc 2: "+p1.nhoHon(p2));
    }
}
