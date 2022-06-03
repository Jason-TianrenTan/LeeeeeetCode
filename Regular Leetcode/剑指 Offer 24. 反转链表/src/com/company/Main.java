package com.company;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null, next = null, curr = head;
        /**
         * prev -> curr -> next
         */
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public void work() {
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
