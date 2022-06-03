package com.company;

public class Main {

    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] f = new int[n + 1][m + 1];
        int[] prefix_sum = new int[n + 1];
        for (int i = 1; i <= n; i++)
            f[i][1] = prefix_sum[i] = prefix_sum[i - 1] + nums[i - 1];

        for (int currIndex = 1; currIndex <= n; currIndex++) {
            for (int count = 2; count <= m; count++) {
                f[currIndex][count] = Integer.MAX_VALUE;
                for (int j = 1; j < currIndex; j++) {
                    f[currIndex][count] = Math.min(f[currIndex][count],
                            Math.max(prefix_sum[currIndex] - prefix_sum[j], f[j][count - 1]));
                }
            }

        }

        return f[n][m];
    }

    public void work() {
        int[] nums = {1000000, 1000000, 1000000, 1000000, 1000000, 1000000};
        int m = 5;
        System.out.println(splitArray(nums, m));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
