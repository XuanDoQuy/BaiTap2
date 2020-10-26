package main;

import objects.Rectange;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double w = sc.nextDouble();
        double h = sc.nextDouble();
        String color = sc.next();
        System.out.println(new Rectange(w,h,color));
    }
}
