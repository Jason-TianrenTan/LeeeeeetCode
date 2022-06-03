package com.company;

public class Main {

    int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        f[0][0] = 0;
        for (int i=1;i<=len1;i++)
            f[i][0] = i;
        for (int j=1;j<=len2;j++)
            f[0][j] = j;
        for (int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++) {
                int add = f[i-1][j] + 1;
                int del = f[i][j-1] + 1;
                int change = f[i-1][j-1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    change++;
                f[i][j] = min(add, del, change);
            }
        return f[len1][len2];
    }

    public void work() {
        String word1 = "intention", word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
