package com.company;

public class Main {

    public class Node {
        int val = 0;
        Node next;
        public Node(int v) {
            this.val = v;
            this.next = null;
        }
    }

    public void work() {
        int[] nums = {1,2,3,4};
        Node head = new Node(nums[0]);
        Node current = head;
        for (int i=1;i<nums.length;i++) {
            Node nNode = new Node(nums[i]);
            current.next = nNode;
            current = nNode;
        }

        while (head!= null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
