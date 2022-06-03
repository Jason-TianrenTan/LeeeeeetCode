package com.company;

public class Main {

    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] col_sum = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                col_sum[j][i] = col_sum[j][i - 1] + matrix[i - 1][j - 1];
        }


        int[] a = new int[n + 1];
        int[] ans = {0, 0, 0, 0};
        int maxArea = matrix[0][0];
        for (int st = 1; st <= m; st++) {
            for (int ed = st; ed <= m; ed++) {
                int[] f = new int[n + 1];
                for (int j = 1; j <= n; j++)
                    a[j] = col_sum[j][ed] - col_sum[j][st - 1];
                f[1] = a[1];
                int currentStart = 1;
                for (int j = 2; j <= n; j++) {
                    if (f[j-1] > 0)
                        f[j] = f[j-1] + a[j];
                    else {
                        f[j] = a[j];
                        currentStart = j;
                    }
                    if (f[j] > maxArea) {
                        maxArea = f[j];
                        ans = new int[]{st - 1, currentStart - 1, ed - 1, j - 1};
                    }
                }
            }
        }
        return ans;
    }

    public void work() {
        int[][] matrix = {
                {9, -8 ,1, 3, -2},
                {-3, 7, 6, -2, 4},
                {6, -4, -4, 8, -7}
        };
        int[] ans = getMaxMatrix(matrix);
        for (int i=0;i<4;i++)
            System.out.print(ans[i] + " ");
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
