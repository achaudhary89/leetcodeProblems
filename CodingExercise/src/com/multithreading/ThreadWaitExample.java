package com.multithreading;

public class ThreadWaitExample {
    private static int total = 330;
    private static int processed = 0;

    public static void main(String[] args) {
        int wait_time = 2000;
        do {
            try {
                System.out.println("waiting for " +wait_time/1000+ " sec"+" processed::"+processed+" total::"+total);
                processRecords();
                Thread.currentThread().sleep(10000);
                if(total < 100){
                    wait_time = 1000;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while (total > 0);{

        }
    }

    private static void processRecords() {
        total -= 100;
        processed += 100;
    }
}
