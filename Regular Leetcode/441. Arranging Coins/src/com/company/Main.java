package com.company;

public class Main {

    public int arrangeCoins(int n) {
        if (n <= 8) {
            int x = 1;
            while (n - x >= 0) {
                n -= x;
                x++;
            }
            return x - 1;
        }
        long left = 1, right = n /2;
        long mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            long sum = mid * (mid + 1) / 2;
            if (sum == n)
                return (int)mid;
            if (sum > n)
                right = mid;
            else left = mid + 1;
        }
        return (int)right - 1;
    }

    public void work() {
        System.out.println(arrangeCoins(1));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
