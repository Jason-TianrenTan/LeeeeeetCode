package com.company;

public class Main {

    public int maxSubArray(int[] nums) {
        int n = nums.length, max = nums[0];
        int pre = nums[0];
        for (int i = 1; i < n; i++) {
            pre = Math.max(nums[i], pre + nums[i]);
            max = Math.max(max, pre);
        }
        return max;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
