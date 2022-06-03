package com.company;

public class Main {

    //    public int search(int[] nums, int target) {
//        int left = 0, right = nums.length - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (nums[mid] == target)
//                return mid;
//            if (nums[mid] > target)
//                right = mid - 1;
//            else left = mid + 1;
//        }
//        return -1;
//    }
    //153
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right])
                left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }

    public void work() {
        int[] nums = {4,3,2,1};
        System.out.println(findMin(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
