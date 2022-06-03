package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    class Graph {
        int V;
        List<Integer>[] adj;

        public Graph(int V) {
            this.V = V;
            this.adj = new List[V];
            for (int i=0;i<V;i++)
                this.adj[i] = new ArrayList<>();
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }
    }

    public boolean validPath(int n, int[][] edges, int start, int end) {
        Graph G = new Graph(n);
        for (int[] e : edges) {
            G.addEdge(e[0], e[1]);
        }
        return findPath(G, start, end, new boolean[n]);
    }

    public boolean findPath(Graph G, int current, int target, boolean[] visited) {
        visited[current] = true;
        if (current == target)
            return true;
        for (int next : G.adj[current]) {
            if (!visited[next] && findPath(G, next, target, visited))
                return true;
        }
        return false;
    }

    public void work() {
        int[][] e = {
                {0, 1},
                {1, 3},
        };
        System.out.println(validPath(4, e, 0, 2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
