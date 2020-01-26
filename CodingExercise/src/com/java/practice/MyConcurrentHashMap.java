package com.java.practice;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyConcurrentHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap map   =   new ConcurrentHashMap();
        Lock lock = new ReentrantLock();
        map.put(1,1);
    }
}
