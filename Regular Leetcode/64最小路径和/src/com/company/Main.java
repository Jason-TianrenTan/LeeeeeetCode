package com.company;

public class Main {

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m + 2][n + 2];
        f[1][1] = grid[0][0];
        for (int i=1;i<=m;i++) {
            f[i][0] = 20001;
            f[i][n+1] = 20001;
        }
        for (int j=1;j<=n;j++) {
            f[0][j] = 20001;
            f[m+1][j] = 20001;
        }
        for (int i=1;i<=m;i++) {
            for (int j=1;j<=n;j++) {
                if (i == 1 && j == 1) continue;
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i-1][j-1];
            }
        }
        return f[m][n];
    }

    public void work() {
        int[][] grid = {{1,2,3},
                {4,5,6}};
        System.out.println(minPathSum(grid));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
