package com.cache;

import java.util.HashMap;

public class LRUCache {

    private HashMap<Integer, Node> cache;
    private DoublyLinkedList doublyLinkedList;
    int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        doublyLinkedList    =   new DoublyLinkedList();
    }

    public void put(int key, int value){
        if(cache.containsKey(key)){
            cache.remove(key);
            doublyLinkedList.remove(cache.get(key));
        }
        Node node = new Node(key, value);

        doublyLinkedList.addFirst(node);
        cache.put(key, node);
    }

    public int get(int key){
        Node n = cache.get(key);
        if(n != doublyLinkedList.getFirst() ){
            updateFreshNess(n);
        }
        return n.val;
    }

    public void remove(int key){
        doublyLinkedList.remove(cache.get(key));
        cache.remove(key);

    }

    private void updateFreshNess(Node n) {
        doublyLinkedList.remove(n);
        doublyLinkedList.addFirst(n);
    }
}

class Node{
    int key;
    int val;
    Node next;
    Node previous;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        next    =    null;
        previous    =   null;
    }
}

class DoublyLinkedList{
    Node head;

    Node tail;

    public DoublyLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.previous = head;
    }

    public void addFirst(Node node){
        node.previous = head;
        node.next = head.next;
        head.next.previous = node;
        head.next = node;
    }

    public void remove(Node node){
        node.previous.next = node.next;
        node.next.previous = node.previous;

    }

    public Node getFirst(){
        if(head.next == tail && tail.previous == head){
            return null;
        }
        return head.next;
    }

    public Node getLast(){

        if(head.next == tail && tail.previous == head){
            return null;
        }
        return tail.previous;

    }
}
