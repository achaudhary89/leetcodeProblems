package com.leetcode.practice.linkedList;

import java.util.List;

class ListNode{
    int val;
    ListNode next;
    ListNode(int v){
        this.val = v;
    }
}
public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ReorderLinkedList linkedList = new ReorderLinkedList();
        linkedList.reorderList(head);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

    public void reorderList(ListNode head){
        if(head == null){
            return;
        }

        //find the middle

        ListNode slow =   head;
        ListNode fast =   head.next;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse the half after the middle

        ListNode head2 = reverse(slow.next);
        slow.next = null;

        //Link the two halves together
        while (head!= null && head2 != null){
            ListNode tmp1 = head.next;
            ListNode tmp2 = head2.next;
            head2.next = head.next;
            head.next = head2;
            head = tmp1;
            head2 = tmp2;
        }


    }

    private ListNode reverse(ListNode n) {
        ListNode prev = null;
        ListNode cur = n;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }
        return prev;
    }
}
