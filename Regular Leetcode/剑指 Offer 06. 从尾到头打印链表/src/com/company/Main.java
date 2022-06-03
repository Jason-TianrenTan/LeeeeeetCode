package com.company;

import java.util.Stack;

public class Main {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty())
            ans[i++] = stack.pop();
        return ans;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
