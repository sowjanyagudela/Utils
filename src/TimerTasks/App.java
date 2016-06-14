/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerTasks;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author sowjanya
 */
public class App {
    
    public static void main(String[] args) {
        TimerTask timerTask = new RunMeTask();
        
        Timer timer = new Timer();
        timer.schedule(timerTask, 1000, 50000);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("RUN Timer Tasks");
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        },0, 5000);
    }
    
}
