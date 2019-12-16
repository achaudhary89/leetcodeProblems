package com.leetcode.practice.fav;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class PairSwap {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        PairSwap pairSwap = new PairSwap();
        ListNode res = pairSwap.swapPairs1(head);
        while (res!=null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(0);
        ListNode out = res;
        ListNode slow   =   head;
        ListNode fast   =   head.next;

        while(fast != null){

            res.next = new ListNode(fast.val);
            res      = res.next;
            res.next = new ListNode(slow.val);
            res  = res.next;
            slow = slow.next.next;
            fast = fast.next == null ? null : fast.next.next;

        }

        if(fast == null && slow!= null){
            res.next = slow;
        }

        return  out.next;
    }

    public ListNode swapPairs1(ListNode head){

        if(head == null || head.next == null){
            return head;
        }
        ListNode n  =   head.next;
        head.next = swapPairs1(head.next.next);
        n.next = head;

        return n;
    }

}
