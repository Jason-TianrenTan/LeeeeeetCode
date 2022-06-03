package com.company;

public class Main {

    public double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i=0;i<k;i++)
            sum+= nums[i];
        int times = nums.length - k;
        long maxsum = sum;
        for (int i=1;i<=times;i++) {
            int left = nums[i - 1], right = nums[i + k - 1];
            sum = sum - left + right;
            maxsum = sum > maxsum ? sum : maxsum;
        }
        return (double)maxsum / k;
    }

    public void work() {
        int[] nums = {111};
        int k = 1;
        System.out.println(findMaxAverage(nums, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
