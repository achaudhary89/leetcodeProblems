package com.leetcode.practice.linkedList;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next =  new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        SwapNodesInPairs linkedList = new SwapNodesInPairs();
        ListNode res    =   linkedList.swapInPair(head);
        while (res != null){
            System.out.println(res.val);
            res = res.next;
        }
    }

    private ListNode swapInPair(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode point = dummy;
        ListNode swap1 = null;
        ListNode swap2 = null;

        while (point.next != null) {
            swap1 = point.next;
            swap2 = point.next.next;
            point.next = swap2;
            swap1.next = swap2.next;
            swap2.next = swap1;
            point = swap1;

        }

        return dummy.next;
    }
}
