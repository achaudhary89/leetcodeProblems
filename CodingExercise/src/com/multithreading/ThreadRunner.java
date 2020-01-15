package com.multithreading;

public class ThreadRunner {
    public static void main(String[] args) {
        Reenterent2 reenterent2 = new Reenterent2();
        Thread t1   =   new Thread(new Runnable() {
            @Override
            public void run() {
                reenterent2.outer();
            }
        },"Thread1");

        Thread t2   =   new Thread(new Runnable() {
            @Override
            public void run() {
                reenterent2.outer();
            }
        }, "Thread2");
        t1.start();
        t2.start();
    }
}
