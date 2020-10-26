package main;

import objects.StackOfIntegers;

import java.util.Scanner;

public class Bai5 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = sc.nextInt();
        StackOfIntegers st = new StackOfIntegers(n);
        int i = 2;
        while (n > 1) {
            while (n % i == 0) {
                n = n / i;
                st.push(i);
            }
            i++;
        }
        while (!st.isEmpty()){
            System.out.println(st.peek());
            st.pop();
        }
    }
}
