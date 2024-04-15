package edu.arkajit.multithreading.joins;

class JoinExample extends Thread{
    public void run(){
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }
}
public class JoinDemoMain {
    public static void main(String[] args)  {
        JoinExample joinExample = new JoinExample();
        joinExample.start();
        try{
            joinExample.join();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }

}
