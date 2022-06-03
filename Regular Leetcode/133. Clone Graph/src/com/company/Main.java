package com.company;

import org.w3c.dom.Node;

import java.util.*;

public class Main {

    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public Node clone() {
            return new Node(this.val, new ArrayList<>(this.neighbors));
        }
    }

    HashMap<Integer, Node> nodes = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        if (nodes.containsKey(node.val))
            return nodes.get(node.val);
        Node clone = new Node(node.val);
        nodes.put(node.val, clone);
        for (Node neighbor : node.neighbors) {
            Node cloneNeighbor = cloneGraph(neighbor);
            clone.neighbors.add(cloneNeighbor);
        }
        return clone;
    }

    public void work() {
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4);
        n1.neighbors.add(n2);
        n1.neighbors.add(n4);
        n3.neighbors.add(n2);
        n3.neighbors.add(n4);
        n2.neighbors.add(n1);
        n2.neighbors.add(n3);
        n4.neighbors.add(n1);
        n4.neighbors.add(n3);
        Node c = cloneGraph(n1);
        Queue<Node> q = new LinkedList<>();
        q.add(c);
        Set<Integer> visited = new HashSet<>();
        visited.add(c.val);
        while (!q.isEmpty()) {
            Node current = q.poll();
            System.out.println("Current : " + current.val);
            for (Node node : current.neighbors) {
                System.out.print(node.val + " ");
                if (!visited.contains(node.val)) {
                    q.add(node);
                    visited.add(node.val);
                }
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        new Main().work();
    }
}
