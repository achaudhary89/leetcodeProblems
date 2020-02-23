package com.cache;

public class LRUTest {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(2,4);
        cache.put(3,5);
        cache.put(4,6);

        System.out.println(cache.get(2));
    }
}
