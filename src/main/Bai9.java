package main;

import objects.StackOfChars;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int b =sc.nextInt();
        StackOfChars st = new StackOfChars();
        while (n>0){
            int x = n % b;
            st.push(convertToChar(x));
            n = n / b;
        }
        while (!st.isEmpty()){
            System.out.print(st.peek());
            st.pop();
        }
    }

    private static char convertToChar (int x){
        if (x<10) return (char) (x + 48);
        else {
            return (char) (x+55);
        }
    }
}
