package com.company;

public class Main {

    public int[] fairCandySwap(int[] A, int[] B) {
        boolean[] fA = new boolean[100001], fB = new boolean[100001];
        int sumA = 0, sumB = 0;
        for (int i=1;i<=100000;i++)
            fA[i] = fB[i] = false;
        for (int x : A) {
            sumA += x;
            fA[x] = true;
        }
        for (int y : B) {
            sumB += y;
            fB[y] = true;
        }
        int div = Math.abs(sumA - sumB) / 2;
        for (int x : A) {
            if (sumA <= sumB && x + div <= 100000 && fB[x + div])
                return new int[]{x, x + div};
            if (sumA >= sumB && x - div >= 1 && fB[x - div])
                return new int[]{x, x -div};
        }
        return null;
    }

    public void work() {
        int[] a = {1, 2, 5}, b = {2, 4};
        int[] ans = fairCandySwap(a, b);
        for (int x : ans) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
