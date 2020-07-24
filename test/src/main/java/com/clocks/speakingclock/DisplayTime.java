package com.clocks.speakingclock;

public class DisplayTime {

    private static final String[] hours = {"one","two","three","four","five","six","seven","eight","nine","ten","eleven",
    "twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
            "nineteen","twenty","twenty one","twenty two","twenty three","twenty four"};

    private static final String[] units = {"one","two","three","four","five","six","seven","eight","nine","ten"};

    private static final String[] teens = {"eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen",
        "nineteen"};
    private static final String[] tens = {"","twenty","thirty","forty","fifty"};

    public String getTime(String inputStr){

        String[] input = new String[2];

        if(!validateInput(inputStr,input)){
            return "Please enter a valid  time";
        }

        Integer hour  = Integer.parseInt(input[0]);
        Integer min =   Integer.parseInt(input[1]);

        if(hour==12 && min==0){
            return "It's Midday";
        }
        if(hour==24 && min==0){
            return "It's Midnight";
        }

        String  result = "It's " + hours[hour -1] + " ";
        if(min==0){
            result +=   "o'clock";
        }else{
            result += getMinuteText(min);
        }


        return result;
    }

    private boolean validateInput(String inputStr, String[] input) {
        if(inputStr==null || !inputStr.contains(":")){
            return false;
        }
        String[] candidateInput = inputStr.split(":");
        if(candidateInput.length !=2){
            return false;
        }
        input[0]=candidateInput[0];
        input[1]=candidateInput[1];

        try{
            Integer.parseInt(input[0]);
            Integer.parseInt(input[1]);
        }catch(NumberFormatException nf){
            System.out.println("Time wrong format");
            return false;
        }
        return true;

    }

    private String getMinuteText(int min){
        String result ="";
        if(min < 11){
            result=units[min-1];
        }else if(min < 20){
            result = teens[min%10 -1].toLowerCase();
        }else{
            result = tens[min/10 -1] ;
            if(min%10 >0) {
              result += " " + units[min % 10 - 1];
            }
            result = result;
        }

        return result;
    }





}
