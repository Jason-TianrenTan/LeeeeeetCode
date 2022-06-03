package com.company;

import java.util.Arrays;

public class Main {

    /**
     * 找到最后一个升序t[i - 1] 严格小于 t[i]
     * t[i]往后再看一位：
     * 1. 如果t[i] 已经是末位，则交换t[i - 1]和t[i]
     * 2. 如果t[i] > t[i + 1]说明后面已经是降序，应当把最后一位（比t[i]大的数字里最小的那个）放到t[i]的位置，然后剩余的从小到大排序
     */

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int st, int ed) {
        int i = st, j = ed - 1;
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        boolean adjusted = false;
        for (int i = n - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                //忽略一样的数字
                adjusted = true;
                int j = i;
                while (j < n - 1 && nums[j] == nums[j + 1])
                    j++;

                if (j == n - 1) {
                    swap(nums, i - 1, i);
                } else {
                    while (j < n && nums[j] > nums[i - 1])
                        j++;
                    swap(nums, i - 1, j - 1);
                    reverse(nums, i, n);
                }
                break;
            }
        }
        if (!adjusted) {
            reverse(nums, 0, n);
        }
    }

    public void work() {
        int[] nums = {2,1,4,3};
        nextPermutation(nums);
        for (int x : nums)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
