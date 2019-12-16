package com.leetcode.practice;

import java.util.concurrent.Semaphore;

public class FooBarImpl {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("alok");

            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("chaudhary");
            }
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
    }
}


class FooBar {
    private int n;

    Semaphore semaphorefoo  =   new Semaphore(1);
    Semaphore semaphorebar  =   new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            semaphorefoo.acquire();
            printFoo.run();
            semaphorebar.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            semaphorebar.acquire();
            printBar.run();
            semaphorefoo.release();
        }
    }
}
