package com.multithreading;

public class MyReenterentLock {
    private boolean isLocked = false;
    private Thread lockedBy =   null;
    private int count = 0;

    public synchronized void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && lockedBy != callingThread){
            wait();
        }
        count++;
        isLocked = true;
        lockedBy = callingThread;

    }

    public synchronized void unlock() throws InterruptedException{
        if(Thread.currentThread() == this.lockedBy){
            this.count--;
        }

        if(count == 0){
            isLocked = false;
            notify();
        }
    }
}
