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

    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * ...->current->predecessor->pred_next->...
     * for each iteration change the next node of predecessor back to current,
     * and then push current and predecessor one node further in the linked list.
     * Therefore after a single iteration the list will be fully reversed.
     */
    private ListNode reverseList(ListNode head) {
        ListNode current = head, predecessor = head.next, pred_next = null;
        head.next = null;
        while (predecessor != null) {
            pred_next = predecessor.next;
            predecessor.next = current;
            current = predecessor;
            predecessor = pred_next;
        }
        return current;
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

    public static void main(String[] args) {
        new Main().work();
    }

    public void work() {
        //init list 1->15
        ListNode head = initList(15);
        System.out.println("Initial List:");
        printList(head);

        //reverse
        head = reverseList(head);
        System.out.println("Reversed List");
        printList(head);
    }
}
