package com.clocks.speakingclock.computation;

public class TimeConsumingProcess {

    protected Integer appliedFactor = 1000;

    long calculateTotals(long seed){
      try{
        Thread.sleep(2000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
      return seed * appliedFactor;
    }



}
