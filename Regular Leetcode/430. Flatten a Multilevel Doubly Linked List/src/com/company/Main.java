package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Definition for a Node.

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        //debug
        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

        public Node() {
        }
    }

    Node tail = null;

    public Node flatten(Node head) {
        if (head == null) return null;

        head.prev = tail;
        tail = head;

        Node nextNode = head.next;

        head.next = flatten(head.child);
        head.child = null;

        tail.next = flatten(nextNode);

        return head;
    }


    public void work() {
        Node n2 = new Node(), n3 = new Node(), n1 = new Node();

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
