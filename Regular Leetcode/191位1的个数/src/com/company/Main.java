package com.company;

public class Main {

    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n = n & (n - 1);
        }
        return res;
    }


    public void work() {
        int n = 0b11111111111111111111111111101111;
        System.out.println(hammingWeight(n));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
