package com.clocks.speakingclock;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class TimeObj {

    private String val;

    public TimeObj(String val) {
        this.val = val;
    }


}
