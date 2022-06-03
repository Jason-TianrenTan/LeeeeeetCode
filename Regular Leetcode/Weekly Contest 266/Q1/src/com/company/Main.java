package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (c == vowel)
                return true;
        }
        return false;
    }

    public int countVowelSubstrings(String word) {
        char[] ch = word.toCharArray();
        int count = 0;
        for (int i = 0; i <= ch.length - 5; i++) {
            int pt = i;
            Set<Character> seen = new HashSet<>();
            while (pt < ch.length && isVowel(ch[pt])) {
                seen.add(ch[pt]);
                pt++;
                if (seen.size() == 5)
                    count++;
            }
        }
        return count;
    }

    public void work() {
        String str = "aeioouuuou";
        System.out.println(countVowelSubstrings(str));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
