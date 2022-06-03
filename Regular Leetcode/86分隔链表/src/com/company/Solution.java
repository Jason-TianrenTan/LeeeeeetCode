package com.company;

import java.util.ArrayList;

public class Solution {

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ArrayList<Integer> small = new ArrayList<>();
        ArrayList<Integer> large = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            if (current.val < x)
                small.add(current.val);
            else large.add(current.val);
            current = current.next;
        }

        ListNode nHead = null;
        ListNode tempNode, lastNode = null;
        for (int i=0; i<small.size();i++) {
            tempNode = new ListNode(small.get(i));
            if (lastNode == null) {
                lastNode = tempNode;
                nHead = lastNode;
            }
            else {
                lastNode.next = tempNode;
                lastNode = tempNode;
            }
        }

        for (int i=0; i<large.size();i++) {
            tempNode = new ListNode(large.get(i));
            if (lastNode == null) {
                lastNode = tempNode;
                if (small.size() ==0)
                    nHead = lastNode;
            }
            else {
                lastNode.next = tempNode;
                lastNode = tempNode;
            }
        }
        return nHead;
    }

    public Solution() {
        int[] nums = {2,3,2,2};
        int x = 3;
        ListNode head = new ListNode(nums[0]);
        ListNode last = head;
        ListNode current;
        for (int i=1;i<nums.length;i++) {
            current = new ListNode(nums[i]);
            last.next = current;
            last = current;
        }

        ListNode sol = partition(head, x);
        while (sol != null) {
            System.out.println(sol.val);
            sol = sol.next;
        }
    }


    public static void main(String[] args) {
        // write your code here
        new Solution();
    }
}

