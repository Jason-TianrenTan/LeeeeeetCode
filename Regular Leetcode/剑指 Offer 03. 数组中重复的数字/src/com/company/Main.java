package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index] < 0)
                return index;
            nums[index] *= -1;
        }
        return 0;
    }

    public void work() {
        int[] nums = {3, 4, 2, 0, 0, 1};
        System.out.println(findRepeatNumber(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
