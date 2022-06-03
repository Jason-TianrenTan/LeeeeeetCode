package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    int[] root, rank;
    Set<Integer>[] forbid;
    Set<Integer>[] friends;
    public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (forbid[x].contains(y) || forbid[y].contains(x))
            return false;
        //keep x smaller than y, merge x -> y
        if (x >= y) {
            int temp = x;
            x = y;
            y = temp;
        }
        //y check x
        for (int friend : friends[x]) {
            if (forbid[y].contains(friend))
                return false;
        }
        for (int friend : friends[y]) {
            if (forbid[x].contains(friend))
                return false;
        }
        root[x] = y;
        forbid[y].addAll(forbid[x]);
        if (rank[x] == rank[y] && x != y)
            rank[y]++;
        friends[x].add(y);
        friends[y].add(x);
        return true;
    }

    public boolean[] friendRequests(int n, int[][] restrictions, int[][] requests) {
        root = new int[n];
        rank = new int[n];
        forbid = new Set[n];
        friends = new Set[n];
        boolean[] res = new boolean[requests.length];
        for (int i = 0; i < n; i++) {
            root[i] = i;
            forbid[i] = new HashSet<>();
            friends[i] = new HashSet<>();
        }
        for (int[] restrict : restrictions) {
            int u = restrict[0], v = restrict[1];
            forbid[u].add(v);
            forbid[v].add(u);
        }
        for (int i = 0; i < requests.length; i++) {
            int u = requests[i][0], v = requests[i][1];
            res[i] = union(u, v);
        }
        return res;
    }

    public void work() {
        int[][] r1 = {{0, 1}, {1, 2}, {2, 3}};
        int[][] requests = {
                {0, 4},
                {1, 2},
                {3, 1},
                {3, 4}
        };
        boolean[] res = friendRequests(5, r1, requests);
        for (boolean b : res)
            System.out.print(b + ", ");
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
