package com.company;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public class Edge {
        int x, y, weight;
        int index;

        public Edge(int i, int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.weight = w;
            this.index = i;
        }
    }

    int[] root, rank;

    public int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    public boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y)
            return false;
        if (rank[x] <= rank[y])
            root[x] = y;
        else root[y] = x;
        if (rank[x] == rank[y])
            rank[y]++;
        return true;
    }


    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] es) {
        Edge[] edges = new Edge[es.length];
        Map<Integer, Edge> edgeMap = new HashMap<>();
        root = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++)
            root[i] = i;
        int index = 0;
        for (int[] e : es) {
            Edge edge = new Edge(index, e[0], e[1], e[2]);
            edges[index] = edge;
            edgeMap.put(index++, edge);
        }
        Arrays.sort(edges, Comparator.comparingInt(e -> e.weight));
        //build an MST
        int minCost = 0;
        for (int i = 0; i < edges.length; i++) {
            Edge edge = edges[i];
            if (union(edge.x, edge.y))
                minCost += edge.weight;
        }

        //find critical sets
        Set<Integer> critical = new HashSet<>();

        for (int i = 0; i < edges.length; i++) {
            //reset union
            int cost = 0;
            for (int k = 0; k < n; k++) {
                root[k] = k;
                rank[k] = 0;
            }
            //build MST
            for (int j = 0; j < edges.length; j++) {
                Edge edge = edges[j];
                if (edge.index == i)
                    continue;//skip i

                if (union(edge.x, edge.y))
                    cost += edge.weight;
            }

            for (int j = 1; j < n; j++) {
                if (find(j) != find(j - 1)) {
                    critical.add(i);
                    break;
                }
            }
            if (cost > minCost)
                critical.add(i);
        }

        //find pseudo sets
        List<Integer> pseudo = new ArrayList<>();
        for (int i = 0; i < edges.length; i++) {
            //reset union
            Edge edgeI = edgeMap.get(i);
            for (int k = 0; k < n; k++) {
                root[k] = k;
                rank[k] = 0;
            }
            //use i
            union(edgeI.x, edgeI.y);
            int cost = edgeI.weight;
            //build MST
            for (int j = 0; j < edges.length; j++) {
                Edge edge = edges[j];
                if (edge.index == edgeI.index)
                    continue;//skip i

                if (union(edge.x, edge.y)) {
                    cost += edge.weight;
                }
            }
            if (cost == minCost && !critical.contains(i))
                pseudo.add(i);
        }

        return new ArrayList<>(Arrays.asList(critical.stream().collect(Collectors.toList()), pseudo));
    }

    public static void main(String[] args) {
        // write your code here
    }
}
