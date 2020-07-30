package com.clocks.speakingclock.controller;

import com.clocks.speakingclock.DisplayTime;
import com.clocks.speakingclock.TimeObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
public class TimeController {
	
	@Autowired
    DisplayTime displayTime;

    // curl --data "val=7:21"  localhost:8080/time
        //  @RequestBody LoginForm loginForm
    @PostMapping("/time/")
    public String postTime(@RequestBody TimeObj timeObj){

        return displayTime.getTime(timeObj.getVal());
    }
    @GetMapping("/show/")
    public String getTime(@RequestParam(value = "val", defaultValue = "12:00") String name){
          return displayTime.getTime(name);
    }

	@GetMapping("/timer")
    public  TimeObj doStuffB(@RequestBody TimeObj timeInput){

        return new TimeObj(displayTime.getTime(timeInput.getVal()));
    }









}



