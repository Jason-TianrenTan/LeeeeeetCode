package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int left = 0, right = nums[len - 1] - nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int st = 0, count = 0;
            for (int ed = 1; ed < len; ed++) {
                while (st < ed && nums[ed] - nums[st] > mid)
                    st++;
                count += ed - st;
            }
            if (count >= k)
                right = mid;
            else left = mid + 1;
        }
        return left;
    }

    public void work() {
        int[] nums = {4, 12, 50, 100};
        int k = 2;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
