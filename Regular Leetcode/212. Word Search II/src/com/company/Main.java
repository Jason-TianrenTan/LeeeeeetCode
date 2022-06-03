package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public class TrieNode {
        char ch;
        Map<Character, TrieNode> children;
        boolean isEnd = false;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public TrieNode(char c) {
            this.ch = c;
            this.children = new HashMap<>();
        }

        public void add(char c) {
            this.children.putIfAbsent(c, new TrieNode(c));
        }
    }

    int m, n;
    char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        //build Trie
        this.board = board;
        m = board.length;
        n = board[0].length;

        TrieNode root = new TrieNode('X');

        for (String word : words) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                current.add(word.charAt(i));
                current = current.children.get(word.charAt(i));
                if (i == word.length() - 1)
                    current.isEnd = true;
            }
        }

        //print
//        Queue<TrieNode> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TrieNode node = queue.poll();
//            System.out.println(node.ch);
//            if (node.count > 0) {
//                for (char c = 'a'; c <= 'z'; c++) {
//                    if (node.children[c - 'a'] != null)
//                        queue.add(node.children[c - 'a']);
//                }
//            }
//        }

        //search in Trie
        for (int sr = 0; sr < m; sr++) {
            for (int sc = 0; sc < n; sc++) {
                char st = board[sr][sc];
                if (root.children.containsKey(st)) {
                    boolean[][] visited = new boolean[m][n];
                    visited[sr][sc] = true;
                    StringBuilder path = new StringBuilder();
                    path.append(st);
                    find(root.children.get(st), path, sr, sc, visited);
                }
            }
        }
        return exists.stream().collect(Collectors.toList());
    }


    Set<String> exists = new HashSet<>();
    int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void find(TrieNode current, StringBuilder path, int x, int y, boolean[][] visited) {
        if (current.isEnd) {
            //found a word
            exists.add(path.toString());
        }
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && current.children.containsKey(board[nx][ny])) {
                path.append(board[nx][ny]);
                visited[nx][ny] = true;
                find(current.children.get(board[nx][ny]), path, nx, ny, visited);
                visited[nx][ny] = false;
                path.deleteCharAt(path.length() - 1);
            }
        }
    }

    public void work() {
        char[][] board = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        findWords(board, new String[]{"oath","pea","eat","rain"});
        for (String word :exists)
            System.out.println(word);
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
