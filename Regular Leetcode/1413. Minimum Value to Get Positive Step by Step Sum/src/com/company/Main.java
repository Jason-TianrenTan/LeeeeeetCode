package com.company;

public class Main {

    public int minStartValue(int[] nums) {
        int max = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum <= 0) {
                max = Math.max(max, 1 - sum);
            }
        }
        return max;
    }

    public void work() {
        int[] nums = {1, -2, -3};
        System.out.println(minStartValue(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
