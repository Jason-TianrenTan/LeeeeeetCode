package com.company;

import java.util.*;

public class Main {

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }

    int[] id;

    Map<Integer, Set<Integer>> adjList = new HashMap<>();

    //build adjacency list
    private void buildGraph(List<List<Integer>> connections) {
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adjList.putIfAbsent(u, new HashSet<>());
            adjList.putIfAbsent(v, new HashSet<>());
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
    }

    private void dfs(int current, int from, int curr_id, List<List<Integer>> ans) {
        id[current] = curr_id;
        Set<Integer> neighbors = adjList.get(current);
        for (int next : neighbors) {
            if (next == from)
                continue;
            if (id[next] == -1) { //unvisited
                dfs(next, current, curr_id + 1, ans);
            }
            id[current] = Math.min(id[current], id[next]);
        }
        if (id[current] != id[from])
            ans.add(Arrays.asList(from, current));
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = -1;//unvisited
        buildGraph(connections);

        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, 0, ans);
        return ans;
    }
}
