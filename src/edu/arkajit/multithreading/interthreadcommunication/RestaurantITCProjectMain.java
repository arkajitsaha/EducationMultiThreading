package edu.arkajit.multithreading.interthreadcommunication;

import java.util.ArrayList;
import java.util.List;

class Restaurant{
    private List<Integer> orders = new ArrayList<>();
    int orderId = 1;

    public synchronized void placeOrder(){
       orders.add(orderId);
        System.out.println("Customer PLaced order: Order "+ orderId);
        orderId++;
        notify();
    }

    public synchronized void prepareOrder(int orderId){
        System.out.println("Chef "+orderId+" is preparing order" + orderId);
        notify();

        System.out.println("order "+orderId+" is ready for customer "+ orderId);
    }

    public synchronized int getOrders() throws InterruptedException {
        while(orders.isEmpty()){
            wait();
        }
        return orders.remove(0);
    }
}

class Customer extends Thread{
    Restaurant re;

    public Customer(Restaurant re){
        this.re = re;
    }

    public void run(){
  //      try {
//            Thread.sleep(1000);
            re.placeOrder();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
    }
}

class Chef extends Thread{
    Restaurant re;

    public Chef(Restaurant re){
        this.re = re;
    }
    public void run(){
        try {
            while(true) {
                int orderId = re.getOrders();
//            Thread.sleep(2000);
                re.prepareOrder(orderId);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class RestaurantITCProjectMain {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();

        Chef chef1 = new Chef(restaurant);
        chef1.start();
        Chef chef2 = new Chef(restaurant);
        chef2.start();

        for(int i=1; i<4; i++){
            Customer customer = new Customer(restaurant);
            customer.start();
        }
    }
}
