package com.leetcode.practice;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Foo {

    Lock lock = new ReentrantLock();
    Condition firstCondition = lock.newCondition();
    Condition secoundCondition = lock.newCondition();
    Condition thirdCondition = lock.newCondition();

    public Foo() {

    }


    public void first(Runnable printFirst) throws InterruptedException {
            lock.lock();
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            lock.unlock();
            secoundCondition.signal();

    }

    public void second(Runnable printSecond) throws InterruptedException {

            lock.lock();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            lock.unlock();
            thirdCondition.signal();
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
            lock.lock();
            printThird.run();
            lock.unlock();

    }
}
