package com.company;

import java.util.*;

public class Main {

    class Node {
        int index, weight;

        public Node(int i, int w) {
            index = i;
            weight = w;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        Set<Integer> settled = new HashSet<>();
        List<Node>[] adj = new List[n];
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }
        dist[k - 1] = 0;
        //Nodes are 1-indexed
        for (int[] edge : times) {
            int u = edge[0] - 1, v = edge[1] - 1, weight = edge[2];
            adj[u].add(new Node(v, weight));
        }
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        queue.add(new Node(k - 1, 0));
        while (settled.size() < n) {
            //from u -> v
            if (queue.isEmpty())
                return -1;
            Node u = queue.poll();
            List<Node> neighbors = adj[u.index];
            for (Node v : neighbors) {
                if (!settled.contains(v) && dist[u.index] + v.weight < dist[v.index]) {
                    dist[v.index] = dist[u.index] + v.weight;
                    queue.add(v);
                }
            }
            settled.add(u.index);
        }
        int maxTime = -1;
        for (int time : dist)
            maxTime = Math.max(time, maxTime);
        return maxTime;
    }

    public void work() {
        int[][] times = {
                {4, 2, 76}, {1, 3, 79}, {3, 1, 81}, {4, 3, 30}, {2, 1, 47}, {1, 5, 61}, {1, 4, 99}, {3, 4, 68}, {3, 5, 46}, {
                4, 1, 6}, {5, 4, 7}, {5, 3, 44}, {4, 5, 19}, {2, 3, 13}, {3, 2, 18}, {1, 2, 0}, {5, 1, 25}, {2, 5, 58}, {2, 4, 77}, {
                5, 2, 74}
        };
        System.out.println(networkDelayTime(times, 5, 3));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}



