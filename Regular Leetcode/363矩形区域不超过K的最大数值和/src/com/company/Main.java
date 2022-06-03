package com.company;

public class Main {

    public int maxSumSubmatrix(int[][] matrix, int K) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        int[][] row_sum = new int[m + 1][n + 1];
        int[][] col_sum = new int[n + 1][m + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                row_sum[i][j] = row_sum[i][j - 1] + matrix[i - 1][j - 1];
                col_sum[j][i] = col_sum[j][i - 1] + matrix[i - 1][j - 1];
            }
        }

        int[] a = new int[n + 1];
        for (int st = 1; st <= m; st++) {
            for (int ed = st; ed <= m; ed++) {
                int maxSum = Integer.MIN_VALUE;
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    a[j] = col_sum[j][ed] - col_sum[j][st - 1];
                }
                for (int j = 1; j <= n; j++) {
                    sum = 0;
                    for (int k = j; k <= n; k++) {
                        sum += a[k];
                        if (sum <= K && sum > maxSum)
                            maxSum = sum;
                        if (maxSum == K)
                            return K;
                    }
                }
                ans = Math.max(ans, maxSum);
            }

        }
        return ans;
    }
    /*
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length, n = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int[][] f = new int[m + 1][n + 1];
                f[i][j] = matrix[i-1][j-1];
                for (int y = i; y <= m; y++)
                    for (int x = j; x <= n; x++) {
                        f[y][x] = f[y - 1][x] + f[y][x - 1] - f[y - 1][x - 1] + matrix[y - 1][x - 1];
                        if (f[y][x] <= k && ans < f[y][x])
                            ans = f[y][x];
                    }
            }
        }
        return ans;

    }*/

    public void work() {
        int[][] matrix = {
                {2,2,-1}
        };
        int k = 0;
        System.out.println(maxSumSubmatrix(matrix, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
