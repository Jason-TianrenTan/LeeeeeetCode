package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    Map<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        if (!nodeMap.containsKey(head)) {
            Node copy = new Node(head.val);
            nodeMap.put(head, copy);
            copy.next = copyRandomList(head.next);
            copy.random = copyRandomList(head.random);
            nodeMap.put(head, copy);
        }
        return nodeMap.get(head);
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
