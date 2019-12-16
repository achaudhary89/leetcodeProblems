package com.leetcode.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenterentLockTest{
    OddEvenImpl oddEven =   new OddEvenImpl();

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
        t0.start();
        Thread.sleep(1000);
        t1.start();

    }
}

class OddEvenImpl{
    private final Lock lock =   new ReentrantLock();

    Condition oddCondition  =   lock.newCondition();
    Condition evenCondition =   lock.newCondition();

    private int counter =   1;

    public void printOdd(){
     while(counter < 10) {
         try {
             lock.lock();
             System.out.println("Odd number::" + counter++);
             evenCondition.signal();

             if (counter < 10) {
                 oddCondition.await();
             }
         } catch (InterruptedException e) {
             e.printStackTrace();
         } finally {
             lock.unlock();
         }
     }
    }

    public void printEven(){
      while (counter < 10) {
          try {
              lock.lock();
              System.out.println("Even number::" + counter++);
              oddCondition.signal();
              if (counter < 10) {
                  evenCondition.await();
              }
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();
          }
      }
    }
}