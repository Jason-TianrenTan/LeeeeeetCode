package com.company;

public class Main {

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < numbers[right])
                right = mid;
            else if (numbers[mid] > numbers[right])
                left = mid + 1;
            else right--;
        }
        return numbers[right];
    }

    public void work() {
        int[] numbers = {3, 4, 2, 2, 2, 2};
        System.out.println(minArray(numbers));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
