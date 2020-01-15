package com.multithreading;

public class Reenterent2 {
    public synchronized void outer(){
        System.out.println(Thread.currentThread().getName() + " inside outer");
        inner();
    }

    public synchronized  void inner(){
        System.out.println(Thread.currentThread().getName()+" inside inner");

    }
}
