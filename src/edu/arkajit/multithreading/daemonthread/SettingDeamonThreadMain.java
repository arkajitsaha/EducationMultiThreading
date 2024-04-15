package edu.arkajit.multithreading.daemonthread;

class SetDeamonThread extends Thread{
    public SetDeamonThread(String name){
        super(name);
    }

    public void run(){
        if(Thread.currentThread().isDaemon()){
            System.out.println(Thread.currentThread().getName() + " is a daemon thread");
        }
        else{
            System.out.println(Thread.currentThread().getName() + " is not a daemon thread");
        }
    }

}

public class SettingDeamonThreadMain {
    public static void main(String[] args) {
        SetDeamonThread st = new SetDeamonThread("1st thread");
        SetDeamonThread st1 = new SetDeamonThread("2nd thread");
        SetDeamonThread st2 = new SetDeamonThread("3rd thread");
        st.setDaemon(true);
        st1.setDaemon(true);
        st.start();
        st1.start();
        st2.start();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("thank you");
    }
}
