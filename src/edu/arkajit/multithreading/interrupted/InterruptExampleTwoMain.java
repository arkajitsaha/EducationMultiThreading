package edu.arkajit.multithreading.interrupted;

class InterruptExampleOne extends Thread{
    public void run(){

        try{
            Thread.sleep(1000);
            System.out.println("Hello");

        }catch(Exception e){
            throw new RuntimeException("Thread has been interrupted by "+ e.getMessage());
        }
    }
}

public class InterruptExampleTwoMain {
    public static void main(String[] args) {
        InterruptExampleOne interruptExample = new InterruptExampleOne();
        interruptExample.start();
        try{
            interruptExample.interrupt();
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
