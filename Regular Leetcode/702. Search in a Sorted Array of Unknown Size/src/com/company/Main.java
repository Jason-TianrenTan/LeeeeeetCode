package com.company;

public class Main {

    class ArrayReader {
        int[] arr = {1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 16, 20, 35};

        public int get(int index) {
            if (index >= arr.length)
                return Integer.MAX_VALUE;
            return arr[index];
        }
    }

    public int search(ArrayReader reader, int target) {
        int left = 0, right = 1;
        int mid = 0;
        if (target < reader.get(0))
            return -1;
        while (left < right) {
            mid = left + (right - left) / 2;
            int val = reader.get(mid);
            if (val == target)
                return mid;
            if (val > target) {
                right = mid;
            } else {
                left = mid + 1;
                right *= 2;
            }
        }
        return -1;
    }

    public void work() {
        ArrayReader reader = new ArrayReader();
        int target = 35;
        System.out.println(search(reader, target));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
