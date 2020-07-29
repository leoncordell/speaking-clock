package com.clocks.speakingclock;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DisplayTime {

    Logger logger =  Logger.getLogger(DisplayTime.class.getName());

    private static final String[] hours = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven",
            "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
            "nineteen","twenty","twenty one","twenty two","twenty three","twenty four"};

    private static final String[] units = {"one","two","three","four","five","six","seven","eight","nine","ten"};

    private static final String[] teens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
            "nineteen"};
    private static final String[] tens = {"","twenty","thirty","forty","fifty"};

    private static final String INVALID_TIME = "Please enter a valid  time";
    private static final String MID_DAY = "It's Midday";

    private static final String MID_NIGHT = "It's Midnight";

    private static final String MIN_PAST = "minute past";
    private static final String MINS_PAST = "minutes past";
    private static  final String SPACE = " ";

    ValidateTime validateTime = new ValidateTime();


    public String getTime(String inputStr){

        String[] input = new String[2];

        if(!validateTime.validateInput(inputStr,input)){
            return INVALID_TIME;
        }

        int hour  = Integer.parseInt(input[0]);
        int min =   Integer.parseInt(input[1]);

        if(hour==12 && min==0){
            return MID_DAY;
        }
        if(hour==24 && min==0){
            return MID_NIGHT;
        }

        String  result = "It's ";
        if(min==0){
            result += hours[hour -1] + " " + "o'clock";
        }else{
            result += getMinuteText(min,hour);
        }


        return result;
    }



    private String getMinuteText(int min,int hour){
        StringBuilder sb = new StringBuilder();
        if(min < 11){
                String min_text = min==1?MIN_PAST:MINS_PAST;
                sb.append(units[min - 1]).append(SPACE).append(min_text).append(SPACE).append(hours[hour - 1]);
        }else if(min < 20){
            sb.append(hours[hour -1]).append(SPACE).append(teens[min%10 -1]);
        }else{
            sb.append(hours[hour -1]);
            sb.append(SPACE);
            sb.append(tens[min/10 -1]);
            if(min%10 >0) {
                sb.append(SPACE).append(units[min % 10 - 1]);
            }
        }

        return sb.toString();
    }





}
