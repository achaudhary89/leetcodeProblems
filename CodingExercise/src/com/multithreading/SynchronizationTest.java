package com.multithreading;

public class SynchronizationTest {

    public synchronized void printA() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Inside A");
    }

    public synchronized void printB(){
        System.out.println("Inside B");
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizationTest synchronizationTest = new SynchronizationTest();
        Thread t1   =   new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    synchronizationTest.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2   =   new Thread(new Runnable() {
            @Override
            public void run() {
                synchronizationTest.printB();
            }
        });
        t2.start();
        t1.start();

    }
}
