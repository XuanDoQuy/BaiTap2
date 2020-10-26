package main;

import objects.MyPoint;
import utils.Helper;

import java.util.Scanner;

public class Bai11 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        MyPoint p1, p2, p3;
        p1 = new MyPoint(sc.nextInt(), sc.nextInt());
        p2 = new MyPoint(sc.nextInt(), sc.nextInt());
        p3 = new MyPoint(sc.nextInt(), sc.nextInt());
        double d1 = Helper.distance(p1, p2);
        double d2 = Helper.distance(p1, p3);
        double d3 = Helper.distance(p2, p3);
        System.out.println(d1+" "+d2+" "+d3);

        if (isTamGiac(d1, d2, d3)) {
            System.out.print("3 diem tao thanh tam giac ");
            if (isTamGiacDeu(d1, d2, d3)) {
                System.out.print("deu ");
                return;
            }
            if (isTamGiacVuong(p1, p2, p3)) {
                System.out.print("vuong ");
            }
            if (isTamGiacCan(d1, d2, d3)) {
                System.out.print("can ");
            }
        } else {
            System.out.print("3 diem khong tao thanh tam giac ");

        }
    }

    private static boolean isTamGiacVuong(MyPoint p1, MyPoint p2, MyPoint p3) {
        if (sqrDistance(p1,p2)==sqrDistance(p1,p3)+sqrDistance(p2,p3)) return  true;
        if (sqrDistance(p1,p3)==sqrDistance(p1,p2)+sqrDistance(p2,p3)) return  true;
        if (sqrDistance(p2,p3)==sqrDistance(p1,p2)+sqrDistance(p1,p3)) return  true;
        return false;
    }

    private static boolean isTamGiacCan(double d1, double d2, double d3) {
        return (d1 == d2) || (d2 == d3) || (d1 == d3);
    }

    private static boolean isTamGiacDeu(double d1, double d2, double d3) {
        return (d1 == d2) && (d2 == d3) && (d1 == d3);
    }

    private static boolean isTamGiac(double d1, double d2, double d3) {
        if (d1 + d2 > d3 && d1 + d3 > d2 && d2 + d3 > d1) return true;
        return false;
    }

    private static double sqrDistance(MyPoint p1,MyPoint p2){
        return Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2);
    }

}
