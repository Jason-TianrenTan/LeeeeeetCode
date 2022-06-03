package com.company;

public class Main {

    public void work() {
        int[] nums = {4,4,4,4,4};
        int k = removeDuplicates(nums);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int pos = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[pos++] = nums[i];
            }
        }
        return pos;
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
