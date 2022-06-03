package com.company;

public class Main {

    int[][][] maxPath;
    boolean[][] searched;
    int m, n;

    static final int[][] DIR = {
            {0, 1}, {1, 0}, {-1, 0}, {0, -1} //right, down, up, left
    };

    private void searchPaths(int[][] matrix, int i, int j) {
        if (searched[i][j])
            return;
        for (int index = 0; index < 4; index++) {
            int x = i + DIR[index][0], y = j + DIR[index][1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[i][j] < matrix[x][y]) {
                searchPaths(matrix, x, y);
                maxPath[i][j][index] = Math.max(maxPath[i][j][index], max(maxPath[x][y]) + 1);
            } else maxPath[i][j][index] = 1;
        }
        searched[i][j] = true;
    }

    private int max(int[] args) {
        int max = -1;
        for (int x : args) {
            max = Math.max(x, max);
        }
        return max;
    }

    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        //x, y, dir
        maxPath = new int[m][n][4];
        searched = new boolean[m][n];
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                searchPaths(matrix, i, j);
                System.out.print("Path for [" + i + "][" + j + "] (" + matrix[i][j] + "): ");
                for (int k = 0; k < 4; k++)
                    System.out.print(maxPath[i][j][k] + " ");
                System.out.println();
                ans = Math.max(ans, max(maxPath[i][j]));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
