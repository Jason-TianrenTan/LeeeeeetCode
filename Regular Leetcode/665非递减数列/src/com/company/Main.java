package com.company;

public class Main {


    public boolean checkPossibility(int[] nums) {
        int[] f = new int[nums.length];
        int max_seq = 1;
        for (int i=0;i<nums.length;i++)
            f[i] = 1;
        for (int i=1;i<nums.length;i++) {
            int maxlen = 0;
            for (int j=0;j<i;j++) {
                if (f[j] > maxlen && nums[j] <= nums[i])
                    maxlen = f[j];
            }
            f[i] = maxlen + 1;
            max_seq = f[i] > max_seq ? f[i] : max_seq;
        };
        return max_seq + 1 >= nums.length;
    }

    public void work() {
        int[] nums = {4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
