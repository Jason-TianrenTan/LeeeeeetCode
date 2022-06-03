package com.company;

public class Main {

    public void work() {
        int[] nums = {0,-1, 1};
        System.out.println(pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int i=0;i<nums.length;i++)
            sum += nums[i];
        int current = 0;
        for (int i=0;i<nums.length;i++) {
            if (current == sum - current - nums[i])
                return i;
            current += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
