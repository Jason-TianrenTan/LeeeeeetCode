package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    int[] root, rank;

    private int find(int x) {
        if (x != root[x])
            root[x] = find(root[x]);
        return root[x];
    }

    /**
     * Merge y (smaller rank) into x
     *
     * @param x
     * @param y
     */
    private void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (rank[x] <= rank[y])
            root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y] && x != y)
            rank[y]++;
    }

    public int countComponents(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        for (int[] e : edges) {
           union(e[0], e[1]);
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (root[i] == i)
                count++;
        return count;
    }

    /* 547 Number of provinces
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] > 0)
                    union(i, j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++)
            if (root[i] == i)
                count++;
        return count;
    }*/

    public void work() {

/*        int[][] isConnected = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(findCircleNum(isConnected));*/
        int[][] edges = {

        };
        System.out.println(countComponents(5, edges));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
