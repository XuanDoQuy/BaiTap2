package main;

import exceptions.RowsColumnNotInValid;
import objects.Matrix;

import java.util.Scanner;

public class Bai12 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean  isFinish = false;
        do {
            displayMenu();
            int chooese = sc.nextInt();
            switch (chooese) {
                case 1:
                    findSumAndSub();
                    break;
                case 2:
                    findMul();
                    break;
                case 3:
                    findTranspose();
                    break;
                case 4:
                    isFinish = true;
                    return;
            }
        } while (!isFinish);

    }

    private static void findTranspose() {
        System.out.println("Enter rows and cols : ");
        int r = sc.nextInt();
        int c = sc.nextInt();
        Matrix m  = new Matrix(r,c);
        m.input(sc);
        m.transpose().print();
    }

    private static void findMul() {
        boolean ok = false;
        while (!ok){
            try {
                System.out.println("Enter first matrix: ");
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();
                Matrix m1 = new Matrix(r1, c1);
                m1.input(sc);
                System.out.println("Enter second matrix: ");
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();
                Matrix m2 = new Matrix(r2, c2);
                m2.input(sc);
                Matrix kq = m1.mul(m2);
                kq.print();
                ok = true;
            } catch (RowsColumnNotInValid e){
                ok = false;
                System.out.println(e.getMessage());
                System.out.println("Moi nhap lai: ");
            }
        }
    }

    private static void findSumAndSub()  {
        boolean ok = false;
        while (!ok){
            try {
                System.out.println("Enter first matrix: ");
                int r1 = sc.nextInt();
                int c1 = sc.nextInt();
                Matrix m1 = new Matrix(r1, c1);
                m1.input(sc);
                System.out.println("Enter second matrix: ");
                int r2 = sc.nextInt();
                int c2 = sc.nextInt();
                Matrix m2 = new Matrix(r2, c2);
                m2.input(sc);
                Matrix kqAdd = m1.add(m2);
                kqAdd.print();
                Matrix kqSub = m1.sub(m2);
                kqSub.print();
                ok = true;
            } catch (RowsColumnNotInValid e){
                ok = false;
                System.out.println(e.getMessage());
                System.out.println("Moi nhap lai: ");
            }
        }
    }

    private static void displayMenu(){
        System.out.println("1. Tính tổng và hiệu hai ma trận");
        System.out.println("2. Tính tích hai ma trận");
        System.out.println("3. Tìm chuyển vị của một ma trận");
        System.out.println("4. Kết thúc chương trình");
        System.out.println("Enter Number: ");
    }
}
