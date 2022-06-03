package com.company;

import java.util.*;

public class Main {

    int[] root, rank;

    private int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    private boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return false;
        if (rank[x] <= rank[y])
            root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y])
            rank[y]++;
        return true;
    }

    private int getDist(int[][] points, int i, int j) {
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        root = new int[n];
        rank = new int[n];
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            root[i] = i;
            for (int j = i + 1; j < n; j++)
                edges.add(new int[]{i, j, getDist(points, i, j)});
        }

        Collections.sort(edges, Comparator.comparingInt(e -> e[2]));
        int edgeCounts = 0, cost = 0;
        Iterator<int[]> iter = edges.iterator();
        while (edgeCounts < n - 1) {
            int[] currentEdge = iter.next();
            if (union(currentEdge[0], currentEdge[1])) {
                cost += currentEdge[2];
                edgeCounts++;
            }
        }
        return cost;
    }

    public void work() {
        int[][] points = {
                {0, 0},
        };
        System.out.println(minCostConnectPoints(points));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
