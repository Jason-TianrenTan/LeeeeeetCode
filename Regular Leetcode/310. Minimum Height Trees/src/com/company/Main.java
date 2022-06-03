package com.company;

import java.util.*;

public class Main {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] degree = new int[n];
        int[] depth = new int[n];
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++)
            adj[i] = new ArrayList<>();
        int found = 0;
        for (int[] e : edges) {
            degree[e[0]]++;
            degree[e[1]]++;
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        List<Integer> startList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                startList.add(i);
                depth[i] = 1;
                found++;
            }
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i : startList)
            queue.add(i);
        int maxDepth = 1;
        if (queue.isEmpty())
            return new ArrayList<>(Arrays.asList(0));
        while (found < n) {
            int node = queue.poll();
            visited[node] = true;
        //    System.out.println("Current at " + node);
            for (int next : adj[node]) {
                if (!visited[next]) {
                    degree[next]--;
                    depth[next] = Math.max(depth[next], depth[node] + 1);
                    maxDepth = Math.max(maxDepth, depth[next]);
                //    System.out.println("Visit " + next + ", degree = " + degree[next]);
                    if (degree[next] == 1) {
                        System.out.println();
                        queue.add(next);
                        found++;
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int node : queue) {
            if (depth[node] == maxDepth)
                ans.add(node);
        }
        return ans;
    }

    public void work() {
        int[][] edges = {
                {3, 0},
                {3,1},
                {3,2},
                {3,4},
                {5,4},
        };
        List<Integer> list = findMinHeightTrees(6, edges);
        for (int node : list)
            System.out.println(node);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
