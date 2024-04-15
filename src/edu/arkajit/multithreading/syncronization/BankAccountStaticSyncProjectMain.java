package edu.arkajit.multithreading.syncronization;

class BankAccount{
    static double balance =0;

    //method to deposit
    public  static synchronized void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: "+amount);
    }

    //method to withDraw
    public static synchronized void withdraw(double amount){
        if(balance>=amount){
            System.out.println("Withdrawn: "+ amount);
            balance -= amount;
        }else{
            System.out.println("Insufficient balance");
        }
    }
}

class AccountDeposit extends Thread{
    BankAccount acc;
    double depositAmount;
    public AccountDeposit(BankAccount acc, double depositAmount){
        this.acc = acc;
        this.depositAmount = depositAmount;
    }
    public void run(){
        acc.deposit(depositAmount);
    }
}

class AccountWithDraw extends Thread{
    BankAccount acc;
    double withdrawAmount;
    public AccountWithDraw(BankAccount acc, double withdrawAmount){
        this.acc = acc;
        this.withdrawAmount = withdrawAmount;
    }
    public void run(){
        acc.withdraw(withdrawAmount);
    }
}

public class BankAccountStaticSyncProjectMain {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        AccountDeposit  Acc1 = new AccountDeposit(account,456790);
        Acc1.start();
        AccountDeposit Acc2 = new AccountDeposit(account,789);
        Acc2.start();

        BankAccount account1 = new BankAccount();
        AccountWithDraw Acc3 = new AccountWithDraw(account1,6890);
        Acc3.start();
        AccountWithDraw Acc4 = new AccountWithDraw(account1,910);
        Acc4.start();
    }
}
