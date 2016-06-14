/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

/**
 *
 * @author sowjanya
 */
public class RunnableDemo implements Runnable {

    private String threadName;
    private Thread t;

    public RunnableDemo(String name) {
        threadName = name;
        System.out.println(" Creating Thread::" + threadName);
    }

    @Override
    public void run() {

        try {
            System.out.println("In Thread Demo "+threadName);
            for (int i = 5; i > 0; i--) {
                System.out.println("I Value::" + i +"::"+threadName);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting " + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();
        }
    }
    
    
    public static void main(String[] args) {
        
        RunnableDemo  td = new RunnableDemo("Thread 1");
       
        td.start();
        
         RunnableDemo  td1 = new RunnableDemo("Thread 2");
        
        td1.start();
    }
    
    
}
