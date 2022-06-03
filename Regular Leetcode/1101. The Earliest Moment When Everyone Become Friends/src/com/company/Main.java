package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    int[] root, rank;
    int[] groupSize;

    public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return;
        if (rank[x] <= rank[y]) {
            root[x] = y;
            groupSize[y] += groupSize[x];
        } else {
            root[y] = x;
            groupSize[x] += groupSize[y];
        }
        if (rank[x] == rank[y])
            rank[y]++;
    }

    public int earliestAcq(int[][] logs, int n) {
        root = new int[n];
        rank = new int[n];
        groupSize = new int[n];
        Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < n; i++) {
            root[i] = i;
            groupSize[i] = 1;
        }
        for (int[] log : logs) {
            int u = log[1], v = log[2];
            union(u, v);
            if (groupSize[find(u)] == n)
                return log[0];
        }
        return -1;
    }

    public void work() {
        int[][] logs = {{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}};
        System.out.println(earliestAcq(logs, 4));
    }


    public static void main(String[] args) {
        new Main().work();
    }
}
