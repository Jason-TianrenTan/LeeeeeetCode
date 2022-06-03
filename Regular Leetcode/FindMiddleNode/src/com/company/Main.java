package com.company;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() { }

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize a list which the node's value equals it's initial sequence in the linked list.
     * @param size Size of list
     */
    private ListNode initList(int size) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i=2;i<=size;i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        return head;
    }

    public ListNode findMiddleNode(ListNode head) {
        //special judge
        if (head == null)
            return null;
        if (head.next == null)
            return head;

        /**
         *  pointer1 moves at 1 at a time, while pointer2 moves twice the speed
         *  Therefore when pointer2 arrives at the end, pointer1 shall be in the middle.
         */
        ListNode pt1 = head, pt2 = head.next;
        while (pt2 != null) {
            pt1 = pt1.next;
            pt2 = pt2.next;
            if (pt2 == null)
                return pt1;//for even number lists, it will return the i/2+1 th node.
            pt2 = pt2.next;
        }
        return pt1;
    }

    public void work() {
        ListNode head = initList(16);
        ListNode middle = findMiddleNode(head);
        System.out.println(middle.val);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
