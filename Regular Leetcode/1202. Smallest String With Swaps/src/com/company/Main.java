package com.company;

import java.util.*;
import java.util.stream.Collectors;

public cla    int[] root, rank;

public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
        }

public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (rank[x] <= rank[y])
        root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y])
        rank[y]++;
        }

public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
        root[i] = i;
        for (List<Integer> pair : pairs) {
        int i = pair.get(0), j = pair.get(1);
        union(i, j);
        }

        //Integer : union root
        //List : list of indices under this root
        Map<Integer, List<Integer>> unionIndices = new HashMap<>();
        for (int i = 0; i < n; i++) {
        int _root = find(i);
        unionIndices.putIfAbsent(_root, new ArrayList<>());
        unionIndices.get(_root).add(i);
        }

        Map<Integer, List<Character>> charsToPut = new HashMap<>();
        for (Map.Entry<Integer, List<Integer>> entry : unionIndices.entrySet()) {
        List<Integer> indices = entry.getValue();
        List<Character> chars = new ArrayList<>();
        for (int i : indices)
        chars.add(s.charAt(i));
        Collections.sort(chars);
        charsToPut.put(entry.getKey(), chars);
        }

        Map<Integer, Iterator<Character>> iterators = new HashMap<>();
        for (Map.Entry<Integer, List<Character>> entry : charsToPut.entrySet())
        iterators.put(entry.getKey(), entry.getValue().iterator());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        int _root = find(i);
        sb.append(iterators.get(_root).next());
        }
        return sb.toString();
        }ss Main {



    public void work() {
        String s = "dcabxyz";
        int[][] arr = {
                {0,1},
                {2,3},
                {3,4}
        };
        List<List<Integer>> pairs = new ArrayList<>();
        for (int[] row : arr) {
            List<Integer> list = Arrays.stream(row).boxed().collect(Collectors.toList());
            pairs.add(list);
        }
        System.out.println(smallestStringWithSwaps(s, pairs));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
