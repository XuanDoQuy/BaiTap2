package main;

import objects.StackOfIntegers;

import java.util.Arrays;
import java.util.Scanner;

public class Bai4 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        boolean[] b = new boolean[n+5];
        StackOfIntegers st = new StackOfIntegers(n);
        Arrays.fill(b,true);
        b[0] = false;
        b[1] = false;
        for (int i = 2;i<=n;i++){
            if (b[i]==true){
                for (int j=i;j<=n;j+=i){
                    b[j] = false;
                }
                st.push(i);
            }
        }
        while (!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
