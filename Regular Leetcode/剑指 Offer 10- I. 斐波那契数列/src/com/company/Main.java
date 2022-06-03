package com.company;

public class Main {

    public int fib(int n) {
        if (n <= 2)
            return 1;
        int[] f = new int[n + 1];
        f[1] = f[2] = 1;
        for (int i = 3; i <= n; i++)
            f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
