package edu.arkajit.multithreading;

class NumberPrinter extends Thread{

    String name;
    public NumberPrinter(String name){
        this.name = name;
    }

    @Override
    public void run(){
        Thread.currentThread().setName(name);
        for(int i=0; i<=5; i++){
            System.out.println(Thread.currentThread().getName()+" :" + i);
        }
    }

}

public class NumberPrinterMain{
    public static void main(String[] args) {
        NumberPrinter printer1 = new NumberPrinter("Printer 1");
        NumberPrinter printer2 = new NumberPrinter("Printer 2");

        System.out.println("Printer 1 started");
        printer1.start();

        System.out.println("Printer 2 started");
        printer2.start();

        System.out.println("Is Printer 1 alive? "+ printer1.isAlive());
        System.out.println("Is Printer 2 alive? "+ printer2.isAlive());




    }
}
