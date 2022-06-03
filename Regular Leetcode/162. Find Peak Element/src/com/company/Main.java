package com.company;

import java.util.Arrays;

public class Main {

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1])
                left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public void work() {
        int[] array = {1,2};
        System.out.println(findPeakElement(array));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
