package edu.arkajit.multithreading.syncronization;

class BookTheatreSeat{
    int totalSeats = 10;

    public void bookSeats(int noOfSeats){
       System.out.println("hellow "+ Thread.currentThread().getName());
       System.out.println("hellow "+ Thread.currentThread().getName());
       System.out.println("hellow "+ Thread.currentThread().getName());
       System.out.println("hellow "+ Thread.currentThread().getName());
       System.out.println("hellow "+ Thread.currentThread().getName());
        synchronized (this) {
            if (totalSeats >= noOfSeats) {
                System.out.println("Booking Successful");
                totalSeats -= noOfSeats;
                System.out.println("Remaining seats : " + totalSeats);
            } else {
                System.out.println("Booking Failed");
                System.out.println("Remaining seats : " + totalSeats);
            }
        }
        System.out.println("hello w1 "+ Thread.currentThread().getName());
        System.out.println("hello w1 "+ Thread.currentThread().getName());
        System.out.println("hello w1 "+ Thread.currentThread().getName());
        System.out.println("hello w1 "+ Thread.currentThread().getName());
        System.out.println("hello w1 "+ Thread.currentThread().getName());
    }
}
class BMS extends Thread{

    static BookTheatreSeat obj = new BookTheatreSeat();
    int seats;
    public BMS(int seats){
        this.seats = seats;
    }

    public void run(){
        obj.bookSeats(seats);
    }
}
public class RaceConditionExampleMain {
    public static void main(String[] args) {
        BMS test1 = new BMS(5);
        test1.start();
        BMS test2 = new BMS(6);
        test2.start();
    }
}
