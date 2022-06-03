package com.company;

public class Main {

    public boolean checkInclusion(String s1, String s2) {
        int start = 0, end = 0;
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] freq = new int[26];
        for (int i=0;i<len1;i++) {
            freq[s1.charAt(i) - 'a']--;
            freq[s2.charAt(i) - 'a']++;
        }
        int diff = 0;
        for (int i=0;i<26;i++) {
            if (freq[i] != 0) {
                diff++;
            }
        }
     //   System.out.println("diff = "+ diff);

        end = len1 - 1;
        for (end = len1; end < len2;end++) {
            int x = s2.charAt(end - len1) - 'a', y = s2.charAt(end) - 'a';
            if (x == y) continue;
            freq[x]--;
            freq[y]++;
            if (freq[x] == 0)
                diff--;
            if (freq[x] == -1)
                diff++;
            if (freq[y] == 0)
                diff--;
            if (freq[y] == 1)
                diff++;
        }
        return diff == 0;

    }

    public void work() {
        String s1 = "ab", s2=  "eidbaoooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static void main(String[] args) {
        new Main().work();
    }

}
