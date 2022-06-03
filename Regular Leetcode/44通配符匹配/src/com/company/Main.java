package com.company;

public class Main {


    public boolean isMatch(String s, String p) {
        int len1 = s.length(), len2 = p.length();
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int k=0;k<len2;k++) {
            if (p.charAt(k) == '*')
                f[0][k + 1] = true;
            else break;
        }
        for (int i=1;i<=len1;i++) {
            for (int j=1;j<=len2;j++) {
                if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
                    f[i][j] = f[i-1][j-1];
                if (p.charAt(j-1) == '*')
                    f[i][j] = f[i-1][j] || f[i][j-1];
            }
        }
        return f[len1][len2];
    }

    public void work() {
        String s= "abda", p = "a?*a";
        System.out.println(isMatch(s, p));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
