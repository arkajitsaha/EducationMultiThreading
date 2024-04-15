package edu.arkajit.multithreading.joins;

class JoinExample1 extends Thread{
    Thread mainThread;
    public void setData(Thread mainThread){
        this.mainThread = mainThread;
    }
    public Thread getData(){
        return mainThread;
    }
    public void run(){
         try{
             getData().join();
         }
         catch(Exception e){
             System.out.println(e.getMessage());
        }
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }
}
public class JoinDemoOneMain {
    public static void main(String[] args)  {
        Thread mainThread = Thread.currentThread();
        JoinExample1 joinExample = new JoinExample1();
        joinExample.setData(mainThread);
        joinExample.start();
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }

}
