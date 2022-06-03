package com.company;

import java.util.*;

public class Main {

    Set<Integer>[] adj;
    public boolean leadsToDestination(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        int[] visiting = new int[n];
        adj = new Set[n];
        for (int i = 0; i < n; i++)
            adj[i] = new HashSet<>();
        for (int[] e : edges)
            adj[e[0]].add(e[1]);
        visited[source] = true;
        boolean hasLoop = findLoop(source, visiting);
        if (hasLoop)
            return false;
        for (int state : visiting)
            if (state == 0)
                return false;
        return dfs(source, destination, visited);
    }

    public boolean findLoop(int current, int[] visiting) {
        visiting[current] = -1;//visiting
        for (int node : adj[current]) {
            if (visiting[node] == -1)
                return true;
            if (visiting[node] == 0) {
                boolean hasLoop = findLoop(node, visiting);
                if (hasLoop)
                    return true;
            }
        }
        visiting[current] = 1;//visited
        return false;
    }

    public boolean dfs(int current, int desc, boolean[] visited) {
        if (current == desc)
            return true;
        Set<Integer> neighbors = adj[current];
        System.out.println();
        if (neighbors.size() == 0)
            return false;
        for (int node : neighbors) {
            if (!visited[node]) {
                visited[node] = true;
                if (!dfs(node, desc, visited))
                    return false;
                visited[node] = false;
            }
        }
        return true;
    }

    public void work() {
        int[][] e = {
                {0, 1},
                {1, 3}
        };
        int n = 4;
        System.out.println(leadsToDestination(n, e, 0, 3));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
