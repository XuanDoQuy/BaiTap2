package utils;

import objects.MyPoint;

public class Helper {
    public static int UCLN(int a,int b){
        if(a<b) return UCLN(b,a);
        while (b>0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static int BCNN(int a,int b){
        return (a*b) / UCLN(a,b);
    }

    public static double distance(MyPoint p1, MyPoint p2){
        return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
    }


}
