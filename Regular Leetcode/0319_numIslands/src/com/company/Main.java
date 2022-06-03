package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode createLink(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode current = head;
        for (int i=1;i<numbers.length;i++) {
            ListNode next = new ListNode(numbers[i]);
            current.next = next;
            next.next = null;
            current = next;
        }
        return head;
    }

    void printLink(ListNode link) {
        while (link != null) {
            System.out.print(link.val);
            if (link.next != null)
                System.out.print("->");
            link = link.next;
        }
    }
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        int mid = len/2;
        for (int i=0;i<mid;i++)
            head = head.next;
        return head;
    }

    public Main() {
        int[] numbers = new int[]{1, 3, 4, 5, 9, 10, 23, 55};
        ListNode link = createLink(numbers);
        System.out.println(middleNode(link).val);
    }

    public static void main(String[] args) {
	// write your code here
        new Main();
    }
}
