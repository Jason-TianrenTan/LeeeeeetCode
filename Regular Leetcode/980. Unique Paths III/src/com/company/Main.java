package com.company;

public class Main {

    int m, n;
    int ans = 0;
    int obstacles = 0;
    int startRow, startCol, endRow, endCol;
    static final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    obstacles++;
                    visited[i][j] = true;
                }
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }
                if (grid[i][j] == 2) {
                    endRow = i;
                    endCol = j;
                }
            }
        }
        int pathLen = 0;
        visited[startRow][startCol] = true;
        search(grid, visited, pathLen, startRow, startCol);
        return ans;
    }

    /**
     * @param visited visit matrix
     * @param pathLen number of visited
     * @param row
     * @param col
     * @return
     */
    private void search(int[][] grid, boolean[][] visited, int pathLen, int row, int col) {
        pathLen++;
        if (grid[row][col] == 2) {
            if (pathLen == m * n - obstacles)
                ans++;
            return;
        }
        for (int[] dir : directions) {
            int nr = row + dir[0], nc = col + dir[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                visited[nr][nc] = true;
                search(grid, visited, pathLen, nr, nc);
                visited[nr][nc] = false;
            }
        }
    }

    public void work() {
        int[][] grid = {
                {1,2}
        };
        System.out.println(uniquePathsIII(grid));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
