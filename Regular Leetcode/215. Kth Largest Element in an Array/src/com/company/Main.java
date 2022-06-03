package com.company;

public class Main {

    public int findKthLargest(int[] nums, int k) {
        findK(nums, 0, nums.length, k);
        return nums[k - 1];
    }

    public void findK(int[] nums, int left, int right, int k) {
        int pos = partition(nums, left, right);
        if (pos == k - 1)
            return;
        if (pos > k - 1) {
            findK(nums, 0, pos, k);
        } else findK(nums, pos + 1, right, k);
    }

    public int partition(int[] nums, int left, int right) {
        System.out.println("Partiton [" + left + ", " + right + "]");
        int pivot = right - 1;
        int pos = left;
        for (int i = left; i < right; i++) {
            if (nums[i] > nums[pivot]) {
                int temp = nums[i];
                nums[i] = nums[pos];
                nums[pos] = temp;
                pos++;
            }
        }
        int temp = nums[pos];
        nums[pos] = nums[pivot];
        nums[pivot] = temp;
        for (int x : nums)
            System.out.print(x + " ");
        System.out.println("\nPos = " + pos);
        return pos;
    }

    public void work() {
        int[] nums = {1,1,1,1,1,1};
        System.out.println(findKthLargest(nums, 4));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
