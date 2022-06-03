package com.company.Utils;

public class LinkedList {

    ListNode head = null;
    ListNode current = null;
    int size = 0;
    public class ListNode {
        String val;
        ListNode next;

        ListNode() { }

        ListNode(String val) {
            this.val = val;
        }

        public ListNode getNext() { return this.next; }

        public String getVal() { return this.val; }
    }

    public LinkedList() {
        head = new ListNode();
        current = head;
    }

    public void add(String val) {
        current.next = new ListNode(val);
        current = current.next;
        size++;
    }

    public ListNode getHead() {
        return this.head.next;
    }

    public int getSize() { return this.size; }
}
