package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    List<Integer>[] adjacent;
    int[][] Edges;
    int maxProfit = -1;
    
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        adjacent = new List[n];
        Edges = new int[n][n];
        for (int i=0;i<n;i++)
            Arrays.fill(Edges[i], -1);
        for (int[] e : edges) {
            int v = e[0], u = e[1], dist = e[2];
            if (adjacent[v] == null)
                adjacent[v] = new ArrayList<>();
            if (adjacent[u] == null)
                adjacent[u] = new ArrayList<>();
            adjacent[v].add(u);
            adjacent[u].add(v);
            Edges[v][u] = Edges[u][v] = dist;
        }

        int[] visited = new int[n];
        search(0, 0, maxTime, values, visited);
        return maxProfit;
    }

    public void search(int current, int profit, int time, int[] values, int[] visited) {
        if (visited[current] == 0)
            profit += values[current];
        if (current == 0)
            maxProfit = Math.max(profit, maxProfit);
        visited[current]++;
        if (adjacent[current] != null) {
            for (int node : adjacent[current]) {
                int dist = Edges[current][node];
                if (dist <= time)
                    search(node, profit, time - dist, values, visited);
            }
        }
        visited[current]--;
    }

    public void work() {
        int[] values = {0,1,2};
        int[][] edges = {
                {1,2,10}
        };
        System.out.println(maximalPathQuality(values, edges, 10));

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
