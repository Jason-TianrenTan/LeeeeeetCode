package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public class Edge {
        int x, y, weight;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.weight = w;
        }
    }

    int[] root, rank;

    public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        System.out.println(x + ", " + y);
        if (x == y)
            return false;
        if (rank[x] <= rank[y])
            root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y])
            rank[y]++;
        return true;
    }

    public int minimumCost(int n, int[][] connections) {
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        root = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            root[i] = i;
        }
        for (int[] conn : connections) {
            priorityQueue.add(new Edge(conn[0], conn[1], conn[2]));
        }
        int cost = 0;
        while (!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.poll();
            if (union(e.x, e.y)) {
                cost += e.weight;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (find(i) != find(i - 1))
                return -1;
        }
        return cost;
    }
}
