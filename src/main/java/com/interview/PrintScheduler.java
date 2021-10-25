package com.interview;
import java.util.Timer;
import java.util.TimerTask;

/**
 * PrintScheduler
 */
public class PrintScheduler {
    /**
     * schedule an API call then print emails after deserializing json response every 5 seconds
     */

    

    public static void main(String[] args) {
        // create print task
        TimerTask timerTask = new PrintTimer() ;
        // create timer
        Timer timer = new Timer(true) ;
        // schedule for 5 seconds interval
        timer.scheduleAtFixedRate(timerTask, 0, 5000);
        System.out.println("Started running ...");
        try {
            Thread.sleep(20000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // stop after 20 seconds (4 iterations)
        timer.cancel();
        System.out.println("Ended running ...");
    }
}