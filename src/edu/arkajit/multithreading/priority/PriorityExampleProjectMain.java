package edu.arkajit.multithreading.priority;

class MyThread extends Thread {
   public MyThread(String name){
        super(name);
    }

    public void run(){
        for (int i =0; i<=5; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
public class PriorityExampleProjectMain {
    public static void main(String[] args) {
        MyThread threadOne = new MyThread("ThreadOne");
        threadOne.setPriority(2);
        MyThread threadTwo = new MyThread("ThreadTwo");
        threadTwo.setPriority(6);
        MyThread threadThree = new MyThread("ThreadThree");
        threadThree.setPriority(8);

        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }

}
