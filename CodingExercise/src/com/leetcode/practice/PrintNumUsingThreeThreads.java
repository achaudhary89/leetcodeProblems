package com.leetcode.practice;

public class PrintNumUsingThreeThreads {
    public static void main(String[] args) throws InterruptedException {
        OddEvenImpl oddEven =   new OddEvenImpl();
        Thread t0   =   new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printOdd();
            }
        });

        Thread t1   =   new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printEven();
            }
        });

        Thread t2   =   new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printEven();
            }
        });
        t0.start();
        t1.sleep(1000);
        t1.start();

    }
}
