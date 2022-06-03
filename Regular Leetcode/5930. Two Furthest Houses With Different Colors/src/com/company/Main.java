package com.company;

public class Main {

    public int maxDistance(int[] colors) {
        int n = colors.length;
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (colors[i] != colors[j])
                    maxDist = Math.max(maxDist, j - i);
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {
        // write your code here
    }
}
