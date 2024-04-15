package edu.arkajit.multithreading.joins;

class Medical extends Thread{

    public void run(){
        for(int i=0; i<3; i++){
            System.out.println("medical round : "+i);
        }
    }
}

class SoftTest extends Thread{
    Thread medThread;
    public void setData(Thread medThread){
        this.medThread = medThread;
    }

    public void run(){
        try{
            medThread.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0; i<3; i++){
            System.out.println("soft Test round : "+i);
        }
    }
}

class TestDrive extends Thread{
    Thread softThread;
    public void setData(Thread softThread){
        this.softThread=softThread;
    }
    public void run(){
        try{
            softThread.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0; i<3; i++){
            System.out.println("Test Drive round : "+i);
        }
    }
}

class OfficerSign extends Thread{
    Thread testThread;
    public void setData(Thread testThread){
        this.testThread = testThread;
    }
    public void run(){
        try{
            testThread.join();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        for(int i=0; i<3; i++){
            System.out.println("Officer signatures : "+i);
        }
    }
}


public class JoinProjectMain {
    public static void main(String[] args) {
        Medical med = new Medical();
        SoftTest softTest = new SoftTest();
        TestDrive testDrive = new TestDrive();
        OfficerSign sign = new OfficerSign();
        med.start();

        softTest.setData(med);
        softTest.start();

        testDrive.setData(softTest);
        testDrive.start();

        sign.setData(testDrive);
        sign.start();

    }
}
