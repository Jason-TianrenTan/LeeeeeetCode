package com.company;

import java.util.*;

public class Main {

    int m, n;
    boolean[][] visited;
    static final int[][] DIR = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static final char[] DIR_CHAR = {
            'R', 'L', 'D', 'U'
    };

    int minX, minY;

    private void search(int[][] grid, int i, int j, StringBuilder path) {
        visited[i][j] = true;
        minX = Math.min(minX, i);
        minY = Math.min(minY, j);
        for (int k = 0; k < 4; k++) {
            int x = i + DIR[k][0], y = j + DIR[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visited[x][y] && grid[x][y] == 1) {
                    path.append(DIR_CHAR[k]);
                    search(grid, x, y, path);
                }
            }
        }
    }

    public int numDistinctIslands(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder path = new StringBuilder();
                    minX = i;
                    minY = j;
                    search(grid, i, j, path);
                    islands.add(path.toString());
                    System.out.println(path.toString());
                }
            }
        }
        return islands.size();
    }

    public void work() {
        int[][] grid = {{1, 1, 0, 1, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1},
                {1, 1, 0, 1, 1}};
        System.out.println(numDistinctIslands(grid));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
