package edu.arkajit.multithreading;


class Test extends Thread{
    public Test(String str){
        super(str);
    }
    @Override
    public void run(){

        System.out.println(Thread.currentThread().getName()+" is printing hello");
    }
}
public class MultiThreadingPractice {
    public static void main(String[] args) {
       // Thread.currentThread().setName("good boy");
        //System.out.println(5/0);
        String str = "Arkajit";
        Test t1 = new Test(str);

        t1.start();
    }
}
