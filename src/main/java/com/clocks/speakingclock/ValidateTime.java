package com.clocks.speakingclock;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
@NoArgsConstructor
public class ValidateTime {
    Logger logger =  Logger.getLogger(ValidateTime.class.getName());


     protected boolean validateInput(String inputStr, String[] input) {
        if(inputStr==null || !inputStr.contains(":")){
            return false;
        }
        String[] candidateInput = inputStr.split(":");
        if(candidateInput.length !=2){
            return false;
        }
        input[0]=candidateInput[0];
        input[1]=candidateInput[1];

        int hour ;
         int min ;

        try{
            hour = Integer.parseInt(input[0]);
            min = Integer.parseInt(input[1]);
        }catch(NumberFormatException nf){
            Handler consoleHandler = new ConsoleHandler();
            logger.log(Level.ALL,nf.getMessage());
            System.out.println("Time wrong format");
            return false;
        }


         if(hour < 0 || hour > 24){
            return false;
        }

        if(min<0 || min>59){
            return false;
        }

        return true;

    }

}
