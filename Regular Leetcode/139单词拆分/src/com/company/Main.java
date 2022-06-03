package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] f = new boolean[length + 1];
        for (int i=0;i<=length;i++)
            f[i] = false;
        f[0] = true;
        //f[i]: 以第i-1个字符结尾能否构成
        for (int i=1;i<=length;i++) {
            for (int j=0;j<i;j++) {
                if (f[j] && wordDict.contains(s.substring(j, i))) {
                    f[i] = true;
                }
            }
        }
        return f[length];
    }

    public void work() {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<>(Arrays.asList("cats", "and", "dog"));
        System.out.println(wordBreak(s, wordDict));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
