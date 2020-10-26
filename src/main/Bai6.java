package main;

import objects.StackOfIntegers;

import java.util.Scanner;

public class Bai6 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();
        StackOfIntegers st = new StackOfIntegers(n);
        while (n>0){
            st.push(n%2);
            n=n/2;
        }
        while (!st.isEmpty()){
            System.out.print(st.peek());
            st.pop();
        }
    }
}
