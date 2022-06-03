package com.company;

public class Main {

//    int min(int a, int b, int c) {
//        return Math.min(Math.min(a, b), c);
//    }
    //1289非零偏移
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1)
            return matrix[0][0];
        int[][] f = new int[n + 2][n + 2];
        for (int i=1;i<=n;i++)
            f[1][i] = matrix[0][i - 1];
        for (int j=1;j<=n+1;j++)
            f[j][0] = f[j][n+1] = Integer.MAX_VALUE;

        int ans = Integer.MAX_VALUE;
        for (int i=2;i<=n;i++) {
            for (int j=1;j<=n;j++) {
                int min = Integer.MAX_VALUE;
                for (int k=1;k<=n;k++) {
                    if (k == j)
                        continue;
                    min = Math.min(min, f[i-1][k]);
                }
                f[i][j] = min + matrix[i-1][j-1];
                if (i == n)
                    ans = Math.min(ans, f[i][j]);
            }
        }
        return ans;
    }

    //931
//    public int minFallingPathSum(int[][] matrix) {
//        int n = matrix.length;
//        if (n == 1)
//            return matrix[0][0];
//        int[][] f = new int[n + 2][n + 2];
//        for (int i=1;i<=n;i++)
//            f[1][i] = matrix[0][i - 1];
//        for (int j=1;j<=n+1;j++)
//            f[j][0] = f[j][n+1] = Integer.MAX_VALUE;
//
//        int ans = Integer.MAX_VALUE;
//        for (int i=2;i<=n;i++) {
//            for (int j=1;j<=n;j++) {
//                f[i][j] = min(f[i-1][j], f[i-1][j-1], f[i-1][j+1]) + matrix[i-1][j-1];
//                if (i == n)
//                    ans = Math.min(ans, f[i][j]);
//            }
//        }
//        return ans;
//    }

    public void work() {
        int[][] matrix = {
                {-73, 61, 43, -48, -36},
                {3, 30, 27, 57, 10},
                {96, -76, 84, 59, -15},
                {5, -49, 76, 31, -7},
                {97, 91, 61, -46, 67}};
        System.out.println(minFallingPathSum(matrix));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
