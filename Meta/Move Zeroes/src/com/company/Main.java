package com.company;

public class Main {

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[pos++] = nums[i];
        }
        for (; pos < nums.length; pos++)
            nums[pos] = 0;
    }

    public void work() {
        int[] nums = {0,0,1,1};
        moveZeroes(nums);
        for (int x : nums)
            System.out.print(x + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        new Main().work();
    }
}
