package edu.arkajit.multithreading.interrupted;

class Interrupted extends Thread{
    public void run(){
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
        System.out.println(Thread.interrupted());
//        System.out.println(Thread.currentThread().isInterrupted());
        try{
            for (int i=0; i<=5; i++){
                System.out.println(i);
                Thread.sleep(1000);
                //System.out.println(Thread.interrupted());
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
public class InterruptedExample {
    public static void main(String[] args) {
        Interrupted interrupted = new Interrupted();
        interrupted.start();
        interrupted.interrupt();
    }
}
