package com.clocks.speakingclock;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    private static  final String ENTER_TEXT = "Please Enter a time : (Q to quit)";

    public static void main(String[] args) throws InterruptedException, IOException {
        DisplayTime dt = new DisplayTime();
        Scanner sc = new Scanner(System.in);
        String input ="";
        boolean quit =false;

        do {
            System.out.println(ENTER_TEXT);
            input=sc.nextLine();
            System.out.println(dt.getTime(input));
        }while(!input.equals("Q"));

    }
}
