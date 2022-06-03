package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    class Graph {
        List<Character>[] adj;
        int[] degree;

        public Graph() {
            this.adj = new List[26];
            this.degree = new int[26];
            for (int i = 0; i < 26; i++)
                this.adj[i] = new ArrayList<>();
        }

        /**
         * x -> y (x < y)
         *
         * @param x
         * @param y
         */
        public void addEdge(char x, char y) {
            adj[x - 'a'].add(y);
            degree[y - 'a']++;
        }
    }

    Graph G;
    Set<Character> seen;
    /**
     * find first different character
     * @param pre
     * @param post
     */
    public void findDifference(String pre, String post) {
        int len = Math.min(pre.length(), post.length());
        int current = 0;
        while (current < len && pre.charAt(current) == post.charAt(current))
            current++;
        if (current < len)
            G.addEdge(pre.charAt(current), post.charAt(current));
    }
    /**
     * compare by digit
     * then by word
     */
    public String alienOrder(String[] words) {
        int n = words.length;
        seen = new HashSet<>();
        G = new Graph();
        for (String word : words)
            for (int i=0;i<word.length();i++)
                seen.add(word.charAt(i));

        for (int i = 0; i < n - 1; i++) {
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1]))
                return "";
            findDifference(words[i], words[i + 1]);
        }
        //topological sort
        int count = 0;
        Queue<Character> queue = new LinkedList<>(), dict = new LinkedList<>();
        for (char ch : seen)
            if (G.degree[ch - 'a'] == 0)
                queue.add(ch);
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            count++;
            dict.add(ch);
            for (char next : G.adj[ch - 'a']) {
                G.degree[next - 'a']--;
                if (G.degree[next - 'a'] == 0)
                    queue.add(next);
            }
        }
        if (count == seen.size())
            return dict.stream().map(String::valueOf).collect(Collectors.joining());
        return "";
    }

    public void work() {
        String[] words = {"abcd", "abcde"};
        System.out.println(alienOrder(words));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
