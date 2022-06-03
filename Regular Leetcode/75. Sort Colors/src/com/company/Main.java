package com.company;

public class Main {

    public void sortColors(int[] nums) {
        int pivot_zero = 0, pivot_two = nums.length - 1;
        while (pivot_zero < nums.length && (nums[pivot_zero] == 0)) {
            pivot_zero++;
        }
        for (int i=pivot_zero + 1;i<nums.length;i++) {
            if (nums[i] == 0) {
                swap(nums, i, pivot_zero);
                while (pivot_zero < nums.length && (nums[pivot_zero] == 0))
                    pivot_zero++;
            }
        }

        while (pivot_two >= 0 && (nums[pivot_two] == 2)) {
            pivot_two--;
        }
        for (int i=pivot_two - 1;i>=0;i--) {
            if (nums[i] == 2) {
                swap(nums, i, pivot_two);
                while (pivot_two >= 0 && (nums[pivot_two] == 2))
                    pivot_two--;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void print(int[] nums) {
        for (int x : nums)
            System.out.print(x + " ");
        System.out.println();
    }

    public void work() {
        int[] nums = {1,0};
        sortColors(nums);
        print(nums);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
