package edu.arkajit.multithreading.yield;

class Test10 extends Thread{
    public void run(){
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}

public class YieldDemoMain {
    public static void main(String[] args) {
        Test10 test = new Test10();
        test.setPriority(Thread.MAX_PRIORITY);
        test.start();
        Thread.yield();
        for(int i=0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+i);
        }
    }
}
