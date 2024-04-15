package edu.arkajit.multithreading.priority;

class MyThreadOne extends Thread{

    public MyThreadOne(String name){
        super(name);
    }

    public void run(){
        for(int i = 0; i<=5; i++){
            System.out.println(Thread.currentThread().getName()+" : Message "+i);
            try{
                Thread.sleep(5000);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

public class PriorityThreadProject2Main {
    public static void main(String[] args) {
        MyThreadOne thread1 =  new MyThreadOne("Thread1");
        MyThreadOne thread2 =  new MyThreadOne("Thread2");
        thread1.start();
        thread2.start();
    }
}
