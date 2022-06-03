package com.company;

import java.util.ArrayList;
import java.util.PriorityQueue;
public class Main {

    int[][] count;
    int ans = 0;
    int k;
    String s;
    public void split(int st, int ed) {//包含st, ed
        if (st > ed || ed - st + 1 < k)
            return;
        System.out.println(st + " -> " + ed);
        int last = st;
        boolean mark = false;
        for (int i=st;i<=ed;i++) {
            int letter = s.charAt(i) - 'a';
            int start;
            if (st == 0)
                start = 0;
            else start = count[letter][st - 1];
            int cnt = count[letter][ed] - start;
            if (cnt < k) {
                mark = true;
                System.out.println("Mark " + s.charAt(i));
                split(last, i - 1);
                last = i + 1;
            }
        }

        if (!mark) {
            int len = ed - st + 1;
            ans = Math.max(len ,ans);
        } else split(last, ed);

    }
    public int longestSubstring(String S, int K) {
        k = K;
        s = S;
        char[] ch = s.toCharArray();
        count = new int[26][s.length()];
        for (int i=0;i<ch.length;i++) {
            int letter = ch[i] - 'a';
            if (i == 0)
                count[letter][0] = 1;
            else {
                count[letter][i] = count[letter][i - 1] + 1;
                for (int l = 0; l < 26; l++) {
                    if (l != letter)
                        count[l][i] = count[l][i - 1];
                }
            }
        }
        split(0, s.length() - 1);
        return ans;
    }

    public void work() {
        String s = "abbbbc";
        int k = 2;
        System.out.println(longestSubstring(s, k));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
