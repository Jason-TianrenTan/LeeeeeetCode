package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length, start = 0, end = n - 1;
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(start);
        findPath(graph, start, end, new boolean[n], currentPath, paths);
        return paths;
    }


    public void findPath(int[][] graph, int current, int target, boolean[] visited,
                         List<Integer> currentPath, List<List<Integer>> paths) {
        if (current == target)
            paths.add(currentPath);
        for (int next : graph[current]) {
            if (!visited[next]) {
                List<Integer> copy = new ArrayList<>(currentPath);
                copy.add(next);
                visited[current] = true;
                findPath(graph, next, target, visited, copy, paths);
                visited[current] = false;
            }
        }
    }

    public void work() {
        int[][] graph = {
                {1, 2},
                {3},
                {3},
                {}
        };
        List<List<Integer>> li = allPathsSourceTarget(graph);
        for (List<Integer> path : li) {
            for (int i : path)
                System.out.print(i + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
