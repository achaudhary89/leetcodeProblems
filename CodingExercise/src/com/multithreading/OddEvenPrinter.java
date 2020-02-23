package com.multithreading;

public class OddEvenPrinter {

    private int MAX = 20;

    private boolean isOdd = false;

    private int count = 1;

    private void printOdd(){
        synchronized (this){
            while (count < MAX){
                while(isOdd){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd :: "+count++);
                notify();
                isOdd = true;
            }
        }
    }

    private void printEven(){
        synchronized (this){
            while (count < MAX){
                while (!isOdd){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even ::"+count++);
                notify();
                isOdd = false;
            }
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter oddEvenPrinter   =   new OddEvenPrinter();

        Thread t1     = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenPrinter.printOdd();
            }
        });

        Thread t2   =   new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenPrinter.printEven();
            }
        });

        t1.start();
        t2.start();

       /* try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}
