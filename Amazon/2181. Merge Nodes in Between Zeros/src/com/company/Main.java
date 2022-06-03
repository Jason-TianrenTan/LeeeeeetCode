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

    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        int sum = 0;
        ListNode dummy = new ListNode();
        ListNode resNode = dummy;
        while (current != null) {
            if (current.val == 0) {
                resNode.next = new ListNode(sum);
                resNode = resNode.next;
                sum =0;
            } else
                sum += current.val;
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
