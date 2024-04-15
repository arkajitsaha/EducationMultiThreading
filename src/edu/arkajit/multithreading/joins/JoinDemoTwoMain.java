package edu.arkajit.multithreading.joins;

class JoinExample2 extends Thread{
    Thread mainThread;
//    public void setData(Thread mainThread){
//        this.mainThread = mainThread;
//    }
//    public Thread getData(){
//        return mainThread;
//    }
    public JoinExample2(Thread mainThread){
        this.mainThread = mainThread;
    }
    public void run(){
        try{
            mainThread.join();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }
}
public class JoinDemoTwoMain {
    public static void main(String[] args)  {
        Thread mainThread = Thread.currentThread();
        JoinExample2 joinExample = new JoinExample2(mainThread);
//        joinExample.setData(mainThread);
        joinExample.start();
        for(int i = 0; i<=10; i++){
            System.out.println(Thread.currentThread().getName()+" : "+ i);
        }
    }

}
