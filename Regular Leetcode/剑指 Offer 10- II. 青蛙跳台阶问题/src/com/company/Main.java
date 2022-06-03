package com.company;

public class Main {

    static final int MODULUS = 1000000007;

    public int numWays(int n) {
        if (n == 0)
            return 1;
        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i <= n; i++)
            f[i] = (f[i - 1] + f[i - 2]) % MODULUS;
        return f[n];
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
