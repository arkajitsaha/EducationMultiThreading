package edu.arkajit.multithreading.interrupted;

class InterruptExample extends Thread{
    public void run(){
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println("Hello");
        }
    }
}

public class InterruptExampleOneMain {
    public static void main(String[] args) {
        InterruptExample interruptExample = new InterruptExample();
        interruptExample.start();
        try{
            interruptExample.interrupt();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
