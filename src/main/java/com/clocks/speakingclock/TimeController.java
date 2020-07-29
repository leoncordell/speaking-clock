package com.clocks.speakingclock;

import org.springframework.web.bind.annotation.*;

@RestController
public class TimeController {

    // curl --data "val=7:21"  localhost:8080/time
        //  @RequestBody LoginForm loginForm
    @PostMapping("/time/")
    public String postTime(@RequestBody TimeObj timeObj){
        DisplayTime dt = new DisplayTime();
        return dt.getTime(timeObj.getVal());
    }
    @GetMapping("/show/")
    public String getTime(@RequestParam(value = "val", defaultValue = "12:00") String name){
        DisplayTime dt = new DisplayTime();
        return dt.getTime(name);
    }



}
