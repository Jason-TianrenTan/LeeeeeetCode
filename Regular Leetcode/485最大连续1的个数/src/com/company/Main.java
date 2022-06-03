package com.company;

public class Main {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxlen = 0;
        int current = 0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] == 1)
                current++;
            else {
                maxlen = maxlen > current ? maxlen : current;
                current = 0;
            }
        }
        maxlen = maxlen > current ? maxlen : current;
        return maxlen;
    }

    public void work() {
        int[] nums = {1,1,0,1,1,1,0,0,1,1,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
