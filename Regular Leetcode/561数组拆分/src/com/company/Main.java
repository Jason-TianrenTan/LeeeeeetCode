package com.company;

import java.util.Arrays;

public class Main {

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0;i<nums.length;i+=2) {
            sum += nums[i];
        }
        return sum;
    }

    public void work() {
        int[] nums = {1, 5, 2, 3, 4, 7, 8, 3};
        System.out.println(arrayPairSum(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
