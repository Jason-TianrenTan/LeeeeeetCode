package com.company;

public class Main {

//    public boolean isPerfectSquare(int num) {
//        if (num == 1)
//            return true;
//        long low = 0, high = num / 2;
//        while (low <= high) {
//            long mid = low + (high - low) / 2;
//            long square = mid * mid;
//            if (square == num)
//                return true;
//            if (square < num)
//                low = mid + 1;
//            else high = mid - 1;
//        }
//        return false;
//    }

    public boolean isPerfectSquare(int num) {
        long x = num / 2;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }

    public void work() {
        System.out.println(isPerfectSquare(808201));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
