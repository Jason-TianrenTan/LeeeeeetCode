package com.company;

public class Main {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            if (sum > target)
                right--;
            if (sum < target)
                left++;
        }
        return null;
    }

    public void work() {
        int[] numbers = {2,4};
        int target = 4;
        int[] result = twoSum(numbers, target);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
