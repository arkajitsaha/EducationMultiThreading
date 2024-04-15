package edu.arkajit.multithreading.syncronization;

class BookTheatreSeatOne{
    static int totalSeats = 20;

    public synchronized static void bookSeats(int noOfSeats){

            if (totalSeats >= noOfSeats) {
                System.out.println("Booking Successful");
                totalSeats -= noOfSeats;
                System.out.println("Remaining seats : " + totalSeats);
            } else {
                System.out.println("Booking Failed");
                System.out.println("Remaining seats : " + totalSeats);
            }

    }
}
class ThreadOne extends Thread{

    BookTheatreSeatOne obj;
    int seats;
    public ThreadOne(BookTheatreSeatOne obj,
                  int seats){
        this.obj = obj;
        this.seats = seats;
    }

    public void run(){
        obj.bookSeats(seats);
    }
}

class ThreadTwo extends Thread{

    BookTheatreSeatOne obj;
    int seats;
    public ThreadTwo(BookTheatreSeatOne obj,
                     int seats){
        this.obj = obj;
        this.seats = seats;
    }

    public void run(){
        obj.bookSeats(seats);
    }
}

public class StaticSyncronizationDemoMain {
    public static void main(String[] args) {
        BookTheatreSeatOne obj1 = new BookTheatreSeatOne();
        ThreadOne T1 = new ThreadOne(obj1,6);
        T1.start();
        ThreadOne T2 = new ThreadOne(obj1,10);
        T2.start();

        BookTheatreSeatOne obj2 = new BookTheatreSeatOne();
        ThreadTwo T3 = new ThreadTwo(obj2, 12);
        T3.start();
        ThreadTwo T4 = new ThreadTwo(obj2, 7);
        T4.start();
    }
}
