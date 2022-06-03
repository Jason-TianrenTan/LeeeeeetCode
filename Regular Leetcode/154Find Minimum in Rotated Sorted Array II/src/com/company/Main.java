package com.company;

public class Main {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            if (nums[left] < nums[right])
                return nums[left];
            mid = (right - left) / 2 + left;
            if (nums[mid] == nums[left])
                left++;
            else if (nums[mid] > nums[left])
                left = mid + 1;
            else right = mid;
        }
        return nums[mid];
    }

    public static void main(String[] args) {
	// write your code here
        int[] nums = {1,1,1,1,1,1,1,0,1,1,1,1};
        System.out.println(new Main().findMin(nums));
    }
}
