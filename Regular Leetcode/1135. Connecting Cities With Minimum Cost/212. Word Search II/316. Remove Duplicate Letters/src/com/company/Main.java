package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Main {

    public void work() {
        System.out.println(removeDuplicateLetters("bbcaac"));
    }

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            count[s.charAt(i) - 'a']++;
        Stack<Character> stack = new Stack<>();
        Set<Character> seen = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (!seen.contains(current)) {
                while (!stack.isEmpty() && count[stack.peek() - 'a'] > 1 && stack.peek() > current) {
                    char removed = stack.pop();
                    System.out.println("Pop " + removed);
                    count[removed - 'a']--;
                    seen.remove(removed);
                }
                stack.push(current);
                seen.add(current);
            } else count[current - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (char c : stack)
            sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
