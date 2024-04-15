package edu.arkajit.multithreading.daemonthread;

class DemonThread extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println("it is daemon thread");
        }else{
            System.out.println("child thread");
        }
    }
}
public class DemonThreadMain {
    public static void main(String[] args) {
        DemonThread dt = new DemonThread();
       // Thread.currentThread().setDaemon(true);
        dt.setDaemon(true);
        dt.start();
        System.out.println("thank you");
    }
}
