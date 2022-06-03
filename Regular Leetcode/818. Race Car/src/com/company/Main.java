package com.company;

public class Main {

    public int racecar(int target) {
        int[] f = new int[target + 1];
        for (int i = 1; i <= target; i++)
            f[i] = Integer.MAX_VALUE;
        for (int i = 0; i <= target; i++) {
            for (int forward = 1; (1 << forward) < 2 * i; forward++) {
                int forwardDist = (1 << forward) - 1;
                if (forwardDist == i)
                    f[i] = forward;
                if (forwardDist > i) {
                    f[i] = Math.min(f[i], forward + 1 + f[forwardDist - i]);
                } else if (forwardDist < i) {
                    for (int backward = 0; backward < forward; backward++) {
                        int backwardDist = (1 << backward) - 1;
                        f[i] = Math.min(f[i], forward + 1 + backward + 1 + f[i - forwardDist + backwardDist]);
                    }
                }
            }
        }
        return f[target];
    }

    public static void main(String[] args) {
        // write your code here
    }
}
