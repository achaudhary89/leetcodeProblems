package com.multithreading.udemy;

public class ThreadCreation {
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Error occur");
            }
        });

        t.setName("Misbehaving Thread");
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                /*
                Clean up resources here
                 */
                System.out.println("A critical error occurred in thread "+ t.getName()+" the error is "+ e.getMessage());
            }
        });

        t.start();
    }
}
