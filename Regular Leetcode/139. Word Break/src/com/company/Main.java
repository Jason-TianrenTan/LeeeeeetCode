package com.company;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; i++) {
            //split to (0, j) and (j, i)
            for (int j = 0; j <= i; j++) {
                if (f[j] && dict.contains(s.substring(j, i))) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }

    public static void main(String[] args) {
        // write your code here
    }
}
