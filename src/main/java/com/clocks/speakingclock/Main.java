package com.clocks.speakingclock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;


//@SpringBootApplication
//@ComponentScan(basePackages ={"com.clocks.speakingclock","com.clocks.speakingclock.controller"})
public class Main {
    private static  final String ENTER_TEXT = "Please Enter a time : (Q to quit)";

    public static void main(String[] args)  {
//        SpringApplication.run(Main.class, args);
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
