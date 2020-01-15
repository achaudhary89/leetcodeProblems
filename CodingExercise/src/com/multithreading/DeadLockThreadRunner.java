package com.multithreading;

public class DeadLockThreadRunner {
    public static void main(String[] args) {
        DeadLockExample deadLockExample = new DeadLockExample();
        Thread t1   =   new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLockExample.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Thread1");

        Thread t2   =   new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadLockExample.outer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread2");
        t1.start();
        //t2.start();
    }
}
