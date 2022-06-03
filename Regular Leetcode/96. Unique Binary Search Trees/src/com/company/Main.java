package com.company;

public class Main {

    public int numTrees(int n, int left) {
        return numTrees(left) * numTrees(n - left);
    }

    public int numTrees(int n) {
        if (n <= 1)
            return 1;
        int sum = 0;
        for (int left = 0; left <= n - 1; left++)
            sum += numTrees(n - 1, left);
        return sum;
    }

    public void work() {
        System.out.println(numTrees(1));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
