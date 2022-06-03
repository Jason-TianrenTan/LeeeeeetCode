package com.company;

public class Main {

    static final int[][] DIR = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    boolean[][] visited;
    int m, n;

    private boolean search(int[][] grid, int i, int j) {
        visited[i][j] = true;
        boolean res = true;
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) //border
            res = false;
        for (int[] d : DIR) {
            int x = i + d[0], y = j + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n) {
                if (!visited[x][y] && grid[x][y] == 0) {
                    res = res & search(grid, x, y);
                }
            }
        }
        return res;
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (search(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
