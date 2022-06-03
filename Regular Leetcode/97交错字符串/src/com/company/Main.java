package com.company;

public class Main {

    public boolean isInterleave(String s1, String s2, String s3) {
        int len1 = s1.length(), len2 = s2.length(), Len = s3.length();
        if (len1 + len2 != Len)
            return false;
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i=1;i<=len1;i++) {
            if (s1.charAt(i-1) == s3.charAt(i-1))
                f[i][0] = true;
            else break;
        }
        for (int j=1;j<=len2;j++) {
            if (s2.charAt(j-1) == s3.charAt(j-1))
                f[0][j] = true;
            else break;
        }
        for (int i=1;i<=len1;i++) {
            for (int j=1;j<=len2;j++) {
                boolean f1 = false, f2 = false;
                if (s1.charAt(i-1) == s3.charAt(i+j-1))
                    f1 = f[i-1][j];
                if (s2.charAt(j-1) == s3.charAt(i+j-1))
                    f2 = f[i][j-1];
                f[i][j] = f1 || f2;
            }
        }
        return f[len1][len2];
    }

    public void work() {
        String s1 = "bcdx", s2 = "ggbond", s3 = "bcdx";
        System.out.println(isInterleave(s1, s2, s3));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
