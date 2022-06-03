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

    //1 2 3 6 5 4 7 8 9 10
    //....p p     c n nn
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prev = dummyNode;
        for (int i=1;i<left;i++)
            prev = prev.next;
        ListNode curr = prev.next;
        ListNode next, nextN;
        for (int i=1;i<right - left + 1;i++) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }
        return dummyNode.next;
    }

    public ListNode createLink(int[] nums) {
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i=1;i<nums.length;i++) {
            current.next = new ListNode(nums[i]);
            current = current.next;
        }
        current.next = null;
        return head;
    }

    public void work() {
        int[] nums = {1,3,5,7,9};
        ListNode node = createLink(nums);
        ListNode reverse = reverseBetween(node, 2,2);
        while (reverse != null) {
            System.out.println(reverse.val);
            reverse = reverse.next;
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
