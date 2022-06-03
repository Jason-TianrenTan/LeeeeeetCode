package com.company;

public class Main {

    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = points[0][j];
        for (int i = 1; i < m; i++) {
            int[] left = new int[n], right = new int[n];
            left[0] = dp[i - 1][0];
            right[n - 1] = dp[i - 1][n - 1];
            for (int k = 1; k < n; k++) {
                left[k] = Math.max(left[k - 1], dp[i - 1][k] + k);
            }
            for (int k = n - 1; k >= 0; k--) {
                right[k] = Math.max(right[k + 1], dp[i - 1][k] - k);
            }
            for (int j = 0; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j], points[i][j] + Math.max(-j + left[j], j + right[j]));
            }
        }
        int ans = 0;
        for (int j = 0; j < n; j++)
            ans = Math.max(ans, dp[m - 1][j]);
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
