package com.company;

public class Main {

    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length(), len2 = text2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        f[0][0] = 0;
        for (int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else f[i][j] = Math.max(f[i][j-1], f[i-1][j]);
            }
        return f[len1][len2];
    }

    public void work() {
        String text1 = "caccb", text2 = "acb";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
