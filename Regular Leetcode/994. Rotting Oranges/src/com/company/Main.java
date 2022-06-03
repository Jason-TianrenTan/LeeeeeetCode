package com.company;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Main {

    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int time = 0, visitCount = 0, totalOranges = 0;
        int currentDay, nextDay = 0;
        boolean[] visited = new boolean[m * n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                if (grid[i][j] == 2)
                    queue.add(index);
                if (grid[i][j] > 0)
                    totalOranges++;
            }
        if (totalOranges == 0)
            return 0;
        currentDay = queue.size();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            visited[index] = true;
            visitCount++;
            currentDay--;
            int i = index / n, j = index % n;

            //left
            if (j > 0 && grid[i][j - 1] == 1) {
                int left = i * n + j - 1;
                if (!visited[left]) {
                    queue.add(left);
                    visited[left] = true;
                    nextDay++;
                }
            }
            //right
            if (j + 1 < n && grid[i][j + 1] == 1) {
                int right = i * n + j + 1;
                if (!visited[right]) {
                    queue.add(right);
                    visited[right] = true;
                    nextDay++;
                }
            }
            //top
            if (i > 0 && grid[i - 1][j] == 1) {
                int top = (i - 1) * n + j;
                if (!visited[top]) {
                    queue.add(top);
                    visited[top] = true;
                    nextDay++;
                }
            }
            //bottom
            if (i + 1 < m && grid[i + 1][j] == 1) {
                int bottom = (i + 1) * n + j;
                if (!visited[bottom]) {
                    queue.add(bottom);
                    visited[bottom] = true;
                    nextDay++;
                }
            }

            if (currentDay == 0) {
                time++;
                currentDay = nextDay;
                nextDay = 0;
            }
        }

        return visitCount == totalOranges ? time - 1 : -1;
    }

    public void work() {
        int[][] grid = {{0, 0, 0}};
        System.out.println(orangesRotting(grid));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
