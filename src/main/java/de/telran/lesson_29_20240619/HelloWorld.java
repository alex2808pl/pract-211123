package de.telran.lesson_29_20240619;

import java.util.Scanner;

public class HelloWorld {


    public static void main(String[] args) {

        if (args.length != 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }

}
