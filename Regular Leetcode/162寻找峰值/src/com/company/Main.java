package com.company;

public class Main {

    enum direction {
        UP, DOWN, FLAG
    }

    int[] numbers;

    public int compare(int idx1, int idx2) {
        if (idx1 == -1)
            return -1;
        if (idx2 == numbers.length)
            return 1;
        return numbers[idx1] - numbers[idx2];
    }

    public direction getDir(int index) {
        int res1 = compare(index - 1, index), res2 = compare(index, index + 1);
        if (res1 < 0 && res2 > 0)
            return direction.FLAG;
        if (res1 > 0 && res2 > 0)
            return direction.DOWN;
        if (res1 < 0 && res2 < 0)
            return direction.UP;
        return null;
    }

    public int findPeakElement(int[] nums) {
        numbers = nums;
        int left = 0, right = nums.length;
        direction ldir, rdir, mdir;
        while (left < right) {
            int mid = (left + right) / 2;
            mdir = getDir(mid);
            if (mdir == direction.FLAG)
                return mid;
            if (mdir == direction.UP)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }

    public void work() {
        int[] nums = {-21};
        System.out.println(findPeakElement(nums));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
