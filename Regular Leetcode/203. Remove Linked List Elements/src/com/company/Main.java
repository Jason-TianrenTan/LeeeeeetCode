package com.company;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode current = head;
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode prev = dummy;
        while (current != null) {
            if (current.val == val)
                prev.next = current.next;
            else
                prev = current;
            current = current.next;
        }
        return dummy.next;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
