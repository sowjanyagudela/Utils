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
public class ThreadDemo extends Thread {

    private Thread t;
    private String threadName;

    public ThreadDemo(String name) {
        threadName = name;
        System.out.println("Creating Thread::" + threadName);

    }

    @Override
    public void run() {
        try {

            for (int i = 5; i > 0; i--) {

                System.out.println("i Value::" + i + "::" + threadName);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        System.out.println("Starting Thread::" + threadName);
        if (t == null) {
            t = new Thread(this, threadName);
            t.start();

        }

    }

    public static void main(String[] args) {
//        ThreadDemo td = new ThreadDemo("1");
//        td.start();

        RunnableDemo rd = new RunnableDemo("Thread 2");

        Thread thread = new Thread(rd);
        thread.setPriority(MAX_PRIORITY);
        System.out.println("Starting thread...");
        thread.start();
        
        RunnableDemo rd1 = new RunnableDemo("Thread 3");

        Thread thread1 = new Thread(rd1);
        thread1.setPriority(MIN_PRIORITY);
        thread1.start();
    }

}
