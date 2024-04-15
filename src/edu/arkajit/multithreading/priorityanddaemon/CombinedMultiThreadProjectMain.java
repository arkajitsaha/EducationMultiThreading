package edu.arkajit.multithreading.priorityanddaemon;

class MyDaemonThread extends Thread{

    public MyDaemonThread(String name){
        super(name);
    }

    public void run(){
        for(int i =0; i<10; i++){
            System.out.println(Thread.currentThread().getName()+" : Message "+i);
            try{
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}

class RegularThread extends Thread{

    public RegularThread(String name, int priority){
        super(name);
        setPriority(priority);
    }

    public void run(){
        int count = 0;
        while(count<=100){
            System.out.println(Thread.currentThread().getName()+" : Message "+count);
            count++;
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                System.out.println(e.getMessage());
            }

        }
    }
}

public class CombinedMultiThreadProjectMain {
    public static void main(String[] args) {

        MyDaemonThread daemonThread = new MyDaemonThread("DaemonThread");
        daemonThread.setDaemon(true);
        daemonThread.setPriority(Thread.MAX_PRIORITY);
        daemonThread.start();

        RegularThread thread1 = new RegularThread("Thread1",Thread.NORM_PRIORITY);
        thread1.start();

        RegularThread thread2 = new RegularThread("Thread2",Thread.MIN_PRIORITY);
        thread2.start();
    }
}
