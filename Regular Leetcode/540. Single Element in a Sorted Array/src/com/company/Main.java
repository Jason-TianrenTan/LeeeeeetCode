package com.company;

public class Main {

    /**
     * 一定是奇数个
     * [1,1,2,2,3,3,4,4,5,8,8]
     * [1,1,2,3,3,4,4]
     * [3,3,7,7,10,11,11]
     *
     * 如果左边有偶数个而mid = mid -1 说明在左边
     * 如果左边有奇数个而mid = mid - 1 说明在右边
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid == 0 || mid == n - 1)
                return nums[mid];
            if (mid > 0 && nums[mid] == nums[mid - 1]) {
                if (mid % 2 == 0)
                    right = mid;
                else left = mid + 1;
            } else if (mid + 1 < n && nums[mid] == nums[mid + 1]) {
                if (mid % 2 == 0)
                    left = mid + 1;
                else right = mid;
            } else return nums[mid];
        }
        return nums[left];
    }

    public void work() {
        int[] nums = {3,4,4};
        System.out.println(singleNonDuplicate(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
