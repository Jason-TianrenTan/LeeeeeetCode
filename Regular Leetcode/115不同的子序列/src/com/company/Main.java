package com.company;

public class Main {

    public int numDistinct(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i=0;i<=len1;i++)
            f[i][0] = 1;
        for (int i=1;i<=len1;i++)
            for (int j=1;j<=len2;j++) {
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    f[i][j] = f[i-1][j-1] + f[i-1][j];
                } else f[i][j] = f[i-1][j];
            }
        return f[len1][len2];
    }

    public void work() {
        String s = "rabbbita", t = "rabbit";
        System.out.println(numDistinct(s, t));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
