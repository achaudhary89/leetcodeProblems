package com.leetcode.practice;

import java.util.concurrent.Semaphore;

public class OddEvenPrinter {


    public static void main(String[] args) throws InterruptedException {
        OddEvenImpl1 oddEven = new OddEvenImpl1();
        Thread t0 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printOdd();
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEven.printEven();
            }
        });
        t0.start();
        Thread.sleep(1000);
        t1.start();

    }
}

    class OddEvenImpl1{
        Semaphore semaphoreEven = new Semaphore(0);
        Semaphore semaphoreOdd  = new Semaphore(1);
        private int counter = 1;
        public void printOdd(){
            try {
                while(counter < 10) {
                    semaphoreOdd.acquire();
                    System.out.println("Odd number::" + counter++);
                    semaphoreEven.release();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void printEven(){
            try {
                    while(counter < 10) {
                        semaphoreEven.acquire();
                        System.out.println("Even number::" + counter++);
                        semaphoreOdd.release();
                    }
            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
               //  semaphore.release();
            }
        }
    }

