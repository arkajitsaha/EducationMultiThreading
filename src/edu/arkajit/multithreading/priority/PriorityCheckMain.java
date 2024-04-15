package edu.arkajit.multithreading.priority;

class Example extends Thread{
    public void run(){
        System.out.println("Hello world");
        System.out.println(Thread.currentThread().getPriority());
    }
}

public class PriorityCheckMain {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(-1);
        System.out.println("priority of main thread is : " + Thread.currentThread().getPriority());
        Example example = new Example();
        example.start();
    }
}
