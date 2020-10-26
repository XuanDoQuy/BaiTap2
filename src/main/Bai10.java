package main;

import objects.MyPoint;
import utils.Helper;

import java.util.ArrayList;
import java.util.Scanner;

public class Bai10 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<MyPoint> listPoint = new ArrayList<>();
        double res = -1;
        MyPoint first = new MyPoint(), second = new MyPoint();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double a = sc.nextDouble();
            double b = sc.nextDouble();
            listPoint.add(new MyPoint(a, b));
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double d = Helper.distance(listPoint.get(i), listPoint.get(j));
                if (d > res) {
                    res = d;
                    first = listPoint.get(i);
                    second = listPoint.get(j);
                }
            }
        }
        System.out.println("Diem 1: " + first.getX() + "\t" + first.getY());
        System.out.println("Diem 2: " + second.getX() + "\t" + second.getY());
        System.out.println("Khoang cach: " + res);
    }
}
