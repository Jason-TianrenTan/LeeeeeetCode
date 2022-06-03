package com.company;

public class Main {

    public int search(int[] nums, int target) {
        int start = nums[0];
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            if (target >= start) {
                if (target < nums[mid] || nums[mid] < start)
                    right = mid;
                else left = mid + 1;
            } else {
                if (target < nums[mid] && nums[mid] < start)
                    right = mid;
                else left = mid + 1;
            }
        }
        if (left < nums.length && nums[left] == target)
            return left;
        return -1;
    }

    public void work() {
        int[] nums = {1, 3};
        System.out.println(search(nums, 31));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
