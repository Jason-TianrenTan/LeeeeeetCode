package com.company;

public class Main {

    public int findKthLargest(int[] nums, int k) {
        findK(nums, 0, nums.length - 1, k);
        return nums[k - 1];
    }

    public void findK(int[] nums, int left, int right, int k) {
        int pos = quickSelect(nums, left, right);
        if (pos == k - 1)
            return;
        if (pos > k - 1)
            findK(nums, 0, pos - 1, k);
        else findK(nums, pos + 1, right, k);
    }

    public int quickSelect(int[] nums, int left, int right) {
        int pos = left, pivot = right;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[pos];
                nums[pos] = nums[i];
                nums[i] = temp;
                pos++;
            }
        }
        int temp = nums[right];
        nums[right] = nums[pos];
        nums[pos] = temp;
        return pos;
    }

    public void work() {
        int[] nums = {11,12,15,10};
        System.out.println(findKthLargest(nums, 3));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
