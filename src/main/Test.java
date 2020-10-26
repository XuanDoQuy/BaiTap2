package main;

import objects.StackOfIntegers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args)  {
        String s = "Anh Xuan";
        String[] tokens = s.split(" ");
        for (String v:tokens){
            System.out.println(v);
        }
    }
}
