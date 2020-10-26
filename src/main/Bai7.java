package main;

import objects.StackOfChars;
import objects.StackOfIntegers;

import java.util.Scanner;

public class Bai7 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String epx = sc.next();
        epx = convertToPostFix(epx);
        System.out.println(calculate(epx));
    }

    private static int calculate(String s) {
        StackOfIntegers st = new StackOfIntegers(s.length() + 5);
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (!isOperator(c)){
                st.push(Integer.parseInt(String.valueOf(c)));
            }else{
                int s1 = st.peek();
                st.pop();
                int s2 = st.peek();
                st.pop();
                int res ;
                switch (c){
                    case '+':
                        res = s2 + s1;
                        break;
                    case '-':
                        res = s2 - s1;
                        break;
                    case '*':
                        res = s2*s1;
                        break;
                    case '/':
                        res = s2/s1;
                        break;

                    default:
                        throw new IllegalStateException("Unexpected value: " + c);
                }
                st.push(res);
            }
        }
        return st.peek();
    }

    private static String convertToPostFix(String s) {
        StackOfChars st = new StackOfChars(s.length() + 5);
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                builder.append(c);
                continue;
            }
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
            }
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
