package com.clocks.speakingclock;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        DisplayTime dt = new DisplayTime();
        Scanner sc = new Scanner(System.in);
        String input ="";
        boolean quit =false;
        while(!quit){
            if(sc.hasNext()){
                input=sc.nextLine();
            }
            if(input.equals("Q")){
                quit=true;
                continue;
            }
            if(input.length()>0) {
                System.out.println(dt.getTime(input));
            }else{
                Thread.sleep(5000);
            }
        }

    }
}
