package com.company;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static final int ALPHABET_SIZE = 26;
    TrieNode root = new TrieNode();

    private class TrieNode {
        char ch = '\0';
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        int counts = 0;

        public TrieNode(char character) {
            this.ch = character;
        }

        public TrieNode() {

        }
    }

    public void insert(List<Character> list) {
        TrieNode current = root;
        for (char ch : list) {
            if (current.children[ch - 'a'] == null)
                current.children[ch - 'a'] = new TrieNode(ch);
            current = current.children[ch - 'a'];
        }
        current.counts++;
    }

    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> result = new ArrayList<>();
        List<String> wordList = new ArrayList<>(Arrays.asList(words));
        wordList.forEach(str -> {
            List<Character> chars = new ArrayList<>();
            boolean[] seen = new boolean[ALPHABET_SIZE];
            CharacterIterator iter = new StringCharacterIterator(str);
            while (iter.current() != CharacterIterator.DONE) {
                if (!seen[iter.current() - 'a']) {
                    seen[iter.current() - 'a'] = true;
                    chars.add(iter.current());
                }
                iter.next();
            }
            if (chars.size() <= 7) {
                Collections.sort(chars);
                insert(chars);
            }
        });

        for (String puzzle : puzzles)
            result.add(find(puzzle, root, false));
        return result;
    }


    public int find(String puzzle, TrieNode current, boolean containsFirst) {
        int res = 0;
        if (current.ch == puzzle.charAt(0))
            containsFirst = true;
        if (current.counts > 0)
            res += containsFirst ? current.counts : 0;
        for (int i = 0; i < puzzle.length(); i++) {
            int index = puzzle.charAt(i) - 'a';
            if (current.children[index] != null)
                res += find(puzzle, current.children[index], containsFirst);
        }
        return res;
    }

    public void work() {
        String[] words = {"kkaz","kaaz","aazk","aaaz","abcdefghijklmnopqrstuvwxyz","kkka","kkkz","aaaa","kkkk","zzzz"};
        String[] puzzles = {"kazxyuv"};
        List<Integer> result = findNumOfValidWords(words, puzzles);
        for (int i : result)
            System.out.println(i);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
