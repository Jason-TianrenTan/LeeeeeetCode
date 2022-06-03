package com.company;

public class Main {

    int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i=1;i<=len1;i++) {
            int ascii = s1.charAt(i - 1);
            f[i][0] = f[i-1][0] + ascii;
        }
        for (int j=1;j<=len2;j++) {
            int ascii = s2.charAt(j - 1);
            f[0][j] = f[0][j-1] + ascii;
        }
        for (int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++) {
                //1删，2删，12删
                f[i][j] = min(f[i-1][j] + s1.charAt(i - 1), f[i][j-1] + s2.charAt(j-1),
                        s1.charAt(i-1) == s2.charAt(j-1) ? f[i-1][j-1] : f[i-1][j-1] + s1.charAt(i - 1) + s2.charAt(j - 1));
            }
        return f[len1][len2];
    }

    public void work() {
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
