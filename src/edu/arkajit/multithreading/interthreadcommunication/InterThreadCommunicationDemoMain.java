package edu.arkajit.multithreading.interthreadcommunication;

class Counter extends Thread{
    int count =0;

    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                count += 100;
            }
            this.notify();
        }
        System.out.println("hello");
    }
}

public class InterThreadCommunicationDemoMain {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        c.start();
        synchronized (c){
            c.wait();
        }
        System.out.println("Answer : "+ c.count);
    }
}
