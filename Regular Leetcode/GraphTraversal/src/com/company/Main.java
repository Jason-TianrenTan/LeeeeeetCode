package com.company;

import com.company.Utils.AdjacencyListGraph;

import java.lang.reflect.Array;
import java.util.*;

public class Main {


    public void work() {
        //Left Graph
        char[][] GraphData = {
                {'A','B'},
                {'A','D'},
                {'A','I'},
                {'B','D'},
                {'B','C'},
                {'B','E'},
                {'C','E'},
                {'C','F'},
                {'D','G'},
                {'D','E'},
                {'E','G'},
                {'E','F'},
                {'E','H'},
                {'F','H'},
                {'G','I'},
                {'G','H'},
                {'G','J'},
                {'H','J'},
                {'I','J'}
        };
        AdjacencyListGraph G = new AdjacencyListGraph(GraphData);
        performDFS(G);
    //    performBFS(G);
    }

    public ArrayList<Character> performDFS(AdjacencyListGraph G) {
        ArrayList<Character> result = new ArrayList<>();
        HashSet<Character> visited = new HashSet<>();
        DFS('A', G, visited, result);
        for (char c : result)
            System.out.print(c + " ");
        System.out.println();
        return result;
    }

    public void DFS(char current, AdjacencyListGraph G, HashSet<Character> visited, ArrayList<Character> result) {
        result.add(current);
        visited.add(current);
        Iterator<Character> iter = G.getIterator(current);
        while (iter.hasNext()) {
            char node = iter.next();
            if (!visited.contains(node))
                DFS(node, G, visited, result);
        }
    }

    public ArrayList<Character> performBFS(AdjacencyListGraph G) {
        ArrayList<Character> result = new ArrayList<>();
        BFS(G, 'A', result);
        return result;
    }

    public void BFS(AdjacencyListGraph G, char start, ArrayList<Character> result) {
        Queue<Character> queue = new LinkedList<>();
        HashSet<Character> visited = new HashSet<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            char current = queue.poll();
            result.add(current);
            visited.add(current);
            Iterator<Character> iter = G.getIterator(current);
            while (iter.hasNext()) {
                char node = iter.next();
                if (!visited.contains(node)) {
                    queue.add(node);
                    visited.add(node);
                }
            }
        }
        for (char c : result)
            System.out.print(c + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
