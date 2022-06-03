package com.company;

public class Main {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int count = 0;
        while (xor > 0) {
            xor &= (xor - 1);
            count++;
        }
        return count;
    }

    public void work() {
        System.out.println(hammingDistance(1, 1));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
