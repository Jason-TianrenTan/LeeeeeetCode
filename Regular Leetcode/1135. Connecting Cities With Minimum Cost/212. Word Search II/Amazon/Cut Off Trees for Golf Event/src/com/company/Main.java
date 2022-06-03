package com.company;

import java.util.*;

public class Main {

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size(), n = forest.get(0).size();
        int[][] dirs = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0}
        };
        PriorityQueue<Integer> heights = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int current = forest.get(i).get(j);
                if (current > 1)
                    heights.add(current);
            }
        }
        //bfs
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        int steps = 0;
        int total_steps = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int[] current = queue.poll();
                int x = current[0], y = current[1];
                int height = forest.get(x).get(y);
                if (height == heights.peek()) {
                    visited = new boolean[m][n];
                    visited[x][y] = true;
                    queue = new LinkedList<>();
                    heights.poll();
                    total_steps += steps;
                    steps = 0;
                    if (heights.isEmpty())
                        return total_steps;
                }
                for (int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }

            }
            steps++;
        }
        return -1;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
