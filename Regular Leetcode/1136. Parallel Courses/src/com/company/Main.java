package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    class Graph {
        int V;
        List<Integer>[] adj;
        int[] degree;

        public Graph(int V) {
            this.V = V;
            adj = new List[V + 1];
            degree = new int[V + 1];
            for (int i = 1; i <= V; i++)
                adj[i] = new ArrayList<>();
        }

        public void addEdge(int u, int v) {
            degree[v]++;
            adj[u].add(v);
        }
    }

    public int minimumSemesters(int n, int[][] relations) {
        Graph G = new Graph(n);
        for (int[] re : relations) {
            G.addEdge(re[0], re[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (G.degree[i] == 0)
                queue.add(i);
        }
        int count = 0;
        int semesters = 0;
        while (!queue.isEmpty()) {
            Queue<Integer> nextRound = new LinkedList<>();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                count++;
                for (int neighbor : G.adj[node]) {
                    G.degree[neighbor]--;
                    if (G.degree[neighbor] == 0)
                        nextRound.add(neighbor);
                }
            }
            semesters++;
            queue = nextRound;
        }
        return count == n ? semesters : -1;
    }

    public void work() {
        int[][] re = {
                {1, 2},
                {2, 3},
                {3, 1}
        };
        System.out.println(minimumSemesters(3, re));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
