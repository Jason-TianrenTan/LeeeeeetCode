package com.company;

public class Main {

    int max(int a, int b) {
        return a > b ? a : b;
    }

    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int _max = -100001;
        for (int j=1;j<nums.length;j++) {
            f[j] = nums[j] + max(0, f[j - 1]);
            _max = max(f[j], _max);
        }
        return max(_max, f[0]);
    }

    public void work() {
        int[] nums = new int[]{1};
        System.out.println(maxSubArray(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
