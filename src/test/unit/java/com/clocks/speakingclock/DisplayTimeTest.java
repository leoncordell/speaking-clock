package com.clocks.speakingclock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class DisplayTimeTest {


    ValidateTime validateTimeM = mock(ValidateTime.class);

    ValidateTime validateTime = new ValidateTime();

    DisplayTime displayTime =new DisplayTime();

    @BeforeEach
    void setUp() {
        displayTime.validateTime = validateTime;
    }

    @Test
    public void getTimeHourMin(){
        String input1 ="8:01";
        displayTime.validateTime=validateTimeM;
        Mockito.when(validateTimeM.validateInput(input1,new String[2])).thenReturn(true);
        String result = displayTime.getTime(input1);
        assertEquals("It's one minute past eight",result);
    }



    @Test
    public void getTimeTestA(){
        String input1 ="27:78";
        String[] input = new String[2];

        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTestB(){
        String input1 ="-1:-8";

        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTestD(){
        String input1 ="7:98";
        
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTest(){
        String input1 ="";

        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTest2(){
        String input1 ="8:50:77";
        
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeTest3(){
        String input1 ="8:t";
        
        assertEquals("Please enter a valid  time",displayTime.getTime(input1));
    }

    @Test
    public void getTimeHour(){
        String input1 ="08:00";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's eight o'clock",result);
    }



    @Test
    public void getTimeHourMidday(){
        String input1 ="12:00";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's Midday",result);
    }

    @Test
    public void getTimeHourMidnight(){
        String input1 ="24:00";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's Midnight",result);
    }


    @Test
    public void getTimeMinSingle(){
        String input1 ="08:05";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's five minutes past eight",result);
    }

    @Test
    public void getTimeMinTeen(){
        String input1 ="08:12";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's eight twelve",result);
    }


    @Test
    public void getTimeMinTens(){
        String input1 ="08:40";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's eight forty",result);
    }
    @Test
    public void getTimeMinTensUnits(){
        String input1 ="08:47";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's eight forty seven",result);
    }


    @Test
    public void getTimeMinTensUnits2(){
        String input1 ="08:59";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's eight fifty nine",result);
    }

    @Test
    public void getTimeMinTensUnits3(){
        String input1 ="23:59";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's twenty three fifty nine",result);
    }

    @Test
    public void validateInputTest1(){
        String input1 ="23:59";
        
        String result = displayTime.getTime(input1);
        assertEquals("It's twenty three fifty nine",result);
    }


}