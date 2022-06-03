package com.company.Utils;

import java.util.*;

public class AdjacencyListGraph {

    private HashMap<Character, ArrayList<Character>> adjacencyList;

    public Iterator<Character> getIterator(char v) {
        return adjacencyList.get(v).iterator();
    }

    public void addEdge(char v, char u) {
        if (!adjacencyList.containsKey(v))
            adjacencyList.put(v, new ArrayList<>());
        if (!adjacencyList.containsKey(u))
            adjacencyList.put(u, new ArrayList<>());
        if (!adjacencyList.get(v).contains(u))
            adjacencyList.get(v).add(u);
        if (!adjacencyList.get(u).contains(v))
            adjacencyList.get(u).add(v);
    }

    public AdjacencyListGraph(char[][] graphData) {
        this.adjacencyList = new HashMap<>();
        for (char[] edge : graphData)
            this.addEdge(edge[0], edge[1]);
        this.organize();
    }

    //sort lists
    private void organize() {
        for (Map.Entry<Character, ArrayList<Character>> entry : adjacencyList.entrySet()) {
            entry.getValue().sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o1 - o2;
                }
            });
        }
    }

    public void printGraph() {
        for (Map.Entry<Character, ArrayList<Character>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + ": ");
            for (char c : entry.getValue())
                System.out.print(" -> " + c);
            System.out.println();
        }
    }
}
