package com.company;

public class Main {

    static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    boolean isVowel(char c) {
        for (char vowel : vowels) {
            if (c == vowel)
                return true;
        }
        return false;
    }

    public long countVowels(String word) {
        long ans = 0;
        long length = word.length();
        for (long i = 0; i < length; i++) {
            if (isVowel(word.charAt((int)i))) {
                long plus = (i + 1) * (length - i);
                ans += plus;
            }
        }
        return ans;
    }

    public void work() {
        String word = "ltcd";
        System.out.println(countVowels(word));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
