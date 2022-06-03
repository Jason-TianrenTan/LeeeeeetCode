package com.company;

import javax.swing.text.html.HTMLDocument;
import java.util.Stack;

public class Main {

    public void work() {
        System.out.println(removeDuplicates("pbbcggttciiippooaais", 2));
    }

    void checkRemove(Stack<Character> stack, int k) {

    }


    public String removeDuplicates(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int[] count = new int[sb.length()];
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && sb.charAt(i) == sb.charAt(i - 1))
                count[i] = count[i - 1] + 1;
            else count[i] = 1;
            if (count[i] == k) {
                sb.delete(i - k + 1, i + 1);
                i -= k;
            }
        }

        return sb.toString();
    }



    public static void main(String[] args) {
        new Main().work();
    }
}
