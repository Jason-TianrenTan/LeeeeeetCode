package com.company;

public class Main {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] paths = new int[m][n];
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < m; i++) {
            if (obstacleGrid[i][0] != 1)
                paths[i][0] = paths[i - 1][0] + 1;
        }
        for (int j = 1; j < n; j++) {
            if (obstacleGrid[0][j] != 1)
                paths[0][j] = paths[0][j - 1] + 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }

        return paths[m - 1][n - 1];
    }

    public static void main(String[] args) {
        // write your code here
    }
}
