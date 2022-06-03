package com.company;

public class Main {

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x < 4)
            return 1;
        if (x < 6)
            return 2;
        long left = 1, right = x / 2;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid * mid > x)
                right = mid;
            else left = mid + 1;
        }
        return (int)left - 1;
    }

    public void work() {
        System.out.println(mySqrt(2147483647));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
