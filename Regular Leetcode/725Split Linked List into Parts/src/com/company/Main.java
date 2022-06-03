package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

    private void printList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        ArrayList<ListNode> nodes = new ArrayList<>();
        ListNode[] result = new ListNode[k];
        ListNode curr = head;
        while (curr != null) {
            nodes.add(curr);
            curr = curr.next;
        }
        int totalSize = nodes.size();
        int minSize = totalSize / k;
        if (minSize == 0) {
            for (int i=0;i<totalSize;i++) {
                result[i] = nodes.get(i);
                nodes.get(i).next = null;
            }
            return result;
        }
        int diff = totalSize - k * minSize;
        int currentIndex = 0, extra = 1, endIndex;
        for (int i=0;i<k;i++) {//result[i]
            if (i >= diff)
                extra = 0;
            endIndex = currentIndex + minSize + extra - 1;
            result[i] = nodes.get(currentIndex);
            nodes.get(currentIndex + minSize + extra - 1).next = null;
            currentIndex = endIndex + 1;
        }
        return result;
    }

    private void init(int size, int k) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        for (int i=2;i<=size;i++) {
            current.next = new ListNode(i);
            current = current.next;
        }
        printList(head);
        ListNode[] result = splitListToParts(head, k);
        for (ListNode _head : result) {
            System.out.println("Sublist: ");
            printList(_head);
        }
    }

    public void work() {

        init(5, 6);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
