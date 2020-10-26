package main;

import objects.SinhVien;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma sinh vien: ");
        int msv = Integer.parseInt(sc.nextLine());
        System.out.println("Nhap ten: ");
        String ten = sc.nextLine();
        System.out.println("Nhap lop: ");
        String lop = sc.nextLine();
        System.out.println("Nhap khoa: ");
        String khoa = sc.nextLine();
        System.out.println("Thong tin sinh vien vua nhap:\n"+ new SinhVien(msv,ten,lop,khoa));
    }
}
