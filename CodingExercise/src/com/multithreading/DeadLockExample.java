package com.multithreading;

public class DeadLockExample {
    Lock lock   =   new Lock();

    public  void outer() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName() + " inside outer");
        inner();
        lock.unLock();
    }

    public   void inner() throws InterruptedException {
        lock.lock();
        System.out.println(Thread.currentThread().getName()+" inside inner");
        lock.unLock();

    }
}
