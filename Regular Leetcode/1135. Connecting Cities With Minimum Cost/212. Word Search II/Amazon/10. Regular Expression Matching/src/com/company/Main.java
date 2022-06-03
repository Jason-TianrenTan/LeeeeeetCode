package com.company;

public class Main {

    public void work() {
        System.out.println(isMatch("mappa",
                "m.*p*."));
    }

    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i = 0; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (i > 0) {
                    if ((s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.') && f[i - 1][j - 1])
                        f[i][j] = true;
                }
                if (j > 1 && p.charAt(j - 1) == '*') {
                    if (i > 0) {
                        if ((p.charAt(j - 2) == s.charAt(i - 1) || (p.charAt(j - 2) == '.')) && f[i - 1][j])
                            f[i][j] = true;
                    }
                    if (f[i][j - 2])
                        f[i][j] = true;
                };
                if (i > 0)
                    System.out.println(s.substring(0, i) + ", " + p.substring(0, j) + " : " + f[i][j]);
            }
        }
        return f[len1][len2];
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
