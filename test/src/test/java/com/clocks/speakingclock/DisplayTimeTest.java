package com.clocks.speakingclock;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTimeTest {

    @Test
    public void getTimeTest(){
        String input1 ="";
        DisplayTime displayTime = new DisplayTime();
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTest2(){
        String input1 ="8:50:77";
        DisplayTime displayTime = new DisplayTime();
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTest3(){
        String input1 ="8:t";
        DisplayTime displayTime = new DisplayTime();
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeHour(){
        String input1 ="08:00";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight o'clock",result);
    }

    @Test
    public void getTimeHourMin(){
        String input1 ="08:01";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight one",result);
    }

    @Test
    public void getTimeHourMidday(){
        String input1 ="12:00";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's Midday",result);
    }

    @Test
    public void getTimeHourMidnight(){
        String input1 ="24:00";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's Midnight",result);
    }


    @Test
    public void getTimeMinSingle(){
        String input1 ="08:05";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight five",result);
    }

    @Test
    public void getTimeMinTeen(){
        String input1 ="08:12";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight twelve",result);
    }


    @Test
    public void getTimeMinTens(){
        String input1 ="08:40";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight forty",result);
    }
    @Test
    public void getTimeMinTensUnits(){
        String input1 ="08:47";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight forty seven",result);
    }


    @Test
    public void getTimeMinTensUnits2(){
        String input1 ="08:59";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's eight fifty nine",result);
    }

    @Test
    public void getTimeMinTensUnits3(){
        String input1 ="23:59";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's twenty three fifty nine",result);
    }

    @Test
    public void validateInputTest1(){
        String input1 ="23:59";
        DisplayTime displayTime = new DisplayTime();
        String result = displayTime.getTime(input1);
        assertEquals("It's twenty three fifty nine",result);
    }


}