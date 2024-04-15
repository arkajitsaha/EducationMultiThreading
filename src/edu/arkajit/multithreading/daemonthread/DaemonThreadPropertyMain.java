package edu.arkajit.multithreading.daemonthread;

class Test2 extends Thread{
    public void run(){
        if(Thread.currentThread().isDaemon()) {
            System.out.println("hello");
        }else{
            System.out.println("not daemon");
        }
    }
}
class Test3 extends Thread{
    public void run(){

       Test2 t2 = new Test2();
       t2.start();
    }
}
public class DaemonThreadPropertyMain {
    public static void main(String[] args) {
        Test3 t3 = new Test3();
        t3.setDaemon(true);
        t3.start();

        try{
            Thread.sleep(1000);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }


    }
}
