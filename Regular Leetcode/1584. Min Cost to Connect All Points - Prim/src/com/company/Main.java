package com.company;

import java.util.*;

public class Main {

    class Node {
        public int index;
        public int weight;

        public Node(int i, int w) {
            index = i;
            weight = w;
        }
    }

    private int getDist(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.weight));
        List<Node>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int dist = getDist(points, i, j);
                adj[i].add(new Node(j, dist));
                adj[j].add(new Node(i, dist));
            }
        }

        queue.add(new Node(0, 0));
        int cost = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.index])
                continue;
            visited[node.index] = true;
            cost += node.weight;
            List<Node> neighbors = adj[node.index];
            for (Node v : neighbors)
                if (!visited[v.index])
                    queue.add(v);
        }

        return cost;
    }

    public void work() {
        int[][] points = {
                {0, 0},
                {1, 1},
                {1, 0},
                {-1, 1}
        };
        System.out.println(minCostConnectPoints(points));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
