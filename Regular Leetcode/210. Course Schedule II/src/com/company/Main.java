package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            if (adj[from] == null)
                adj[from] = new ArrayList<>();
            adj[from].add(to);
            indegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        int completed = 0;
        int[] ans = new int[numCourses];
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans[completed++] = current;
            if (adj[current] != null && adj[current].size() > 0) {
                for (int next : adj[current]) {
                    indegree[next]--;
                    if (indegree[next] == 0)
                        queue.add(next);
                }
            }
        }

        return completed == numCourses ? ans : new int[0];
    }

    public static void main(String[] args) {
        // write your code here
    }
}
