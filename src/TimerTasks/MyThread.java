/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TimerTasks;

/**
 *
 * @author sowjanya
 */
public class MyThread extends Thread{
    
    
    @Override
    public void run(){
        System.out.println("Thread Started!!");
    }
    
    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.start();
        mt.start();
        
    }
}
