package edu.arkajit.multithreading;

class Test1 implements Runnable{

    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName()+" is printing hello");
    }
}

public class MultiThreadingPractice2 {
    public static void main(String[] args) {
        Test1 t1 = new Test1();
        Thread thread = new Thread(t1,"Arkajit");
      //  thread.setName("Arkajit");
        thread.start();
        System.out.println(thread.isAlive());
        System.out.println(Thread.currentThread().isAlive());

    }
}
