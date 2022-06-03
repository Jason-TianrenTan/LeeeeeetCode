package com.company;

public class Main {


    //Definition for singly-linked list.
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

    /*
    1 2 2 3 3 4
    p c t
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode dummyNode = prev;
        while (current != null && current.next != null) {
            ListNode temp = current.next;
            if (current.val == temp.val) {
                while (temp != null && current.val == temp.val)
                    temp = temp.next;
                prev.next = temp;
                current = temp;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummyNode.next;
    }

    public ListNode createLink(int[] nums) {
        ListNode dummyNode = new ListNode();
        ListNode current = dummyNode;
        for (int x : nums) {
            current.next = new ListNode(x);
            current = current.next;
        }
        return dummyNode.next;
    }

    public void work() {
        int[] nums = {1,1,1,4,6};
        ListNode head = createLink(nums);
        ListNode nhead = deleteDuplicates(head);
        while (nhead != null) {
            System.out.println(nhead.val);
            nhead = nhead.next;
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
