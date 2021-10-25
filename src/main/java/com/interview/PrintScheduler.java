package com.interview;
import java.util.Timer;
import java.util.TimerTask;

/**
 * PrintScheduler
 */
public class PrintScheduler {
    /**
     * PrintTimer
     */

    

    public static void main(String[] args) {
        TimerTask timerTask = new PrintTimer() ;
        Timer timer = new Timer(true) ;
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer.cancel();
    }
}