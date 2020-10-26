package main;

import objects.StackOfChars;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String epx = sc.next();
        System.out.println(convertToPostfix(epx));
    }

    private static String convertToPostfix(String s) {
        StringBuilder builder = new StringBuilder();
        StackOfChars st = new StackOfChars(s.length() + 5);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(c);
                continue;
            }
            if (c == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    builder.append(st.peek());
                    st.pop();
                }
                if (!st.isEmpty()) st.pop(); // pop '('
                continue;
            }
            if (isOperator(c)) {
                while (!st.isEmpty() && indexOf(st.peek()) >= indexOf(c)) {
                    builder.append(st.peek());
                    st.pop();
                }
                st.push(c);
                continue;
            }
            builder.append(c);
        }
        while (!st.isEmpty()) {
            char c = st.peek();
            if (c != '(' && c != ')') {
                builder.append(c);
            }
            st.pop();
        }
        return builder.toString();
    }

    private static int indexOf(char c) {
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return 0;
    }

    private static boolean isOperator(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
}
