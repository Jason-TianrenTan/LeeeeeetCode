package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[sr][sc] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int[][] dirs = {
                {0, 1}, {0, -1}, {1, 0}, {-1, 0}
        };
        int target = image[sr][sc];
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            image[current[0]][current[1]] = newColor;
            for (int[] dir : dirs) {
                int nr = current[0] + dir[0], nc = current[1] + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && image[nr][nc] == target) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return image;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
