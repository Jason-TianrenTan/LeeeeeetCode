package com.company;

public class Main {

    int[] root, rank;

    public int find(int x) {
        if (x != root[x])
            root[x] = find(root[x]);
        return root[x];
    }

    public void union(int x, int y) {
        if (rank[x] <= rank[y])
            root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y] && x != y)
            rank[y]++;
    }

    public boolean validTree(int n, int[][] edges) {
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0]), y = find(edges[i][1]);
            if (x == y)
                return false;
            union(x, y);
        }
        int count = 0;
        for (int i=0;i<n;i++) {
            if (i == root[i]) {
                count++;
                if (count > 1)
                    return false;
            }
        }
        return true;
    }

    public void work() {
        int[][] edges = {
                {0, 1},
                {2,3}
        };
        System.out.println(validTree(4, edges));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
