package com.company.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdjacencyListGraph {

    int n, m;
    private int[][] EdgeIndices;
    private ArrayList<Integer>[] adjacencyList;

    public void addEdge(int v1, int v2, int EdgeIndex) {
        if (!adjacencyList[v1].contains(v2))
            adjacencyList[v1].add(v2);
        if (!adjacencyList[v2].contains(v1))
            adjacencyList[v2].add(v1);
        EdgeIndices[v1][v2] = EdgeIndices[v2][v1] = EdgeIndex;
    }

    public AdjacencyListGraph(int N) {
        n = N;
        EdgeIndices = new int[n + 1][n + 1];
        this.adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            this.adjacencyList[i] = new ArrayList<>();
    }

    public AdjacencyListGraph(int[][] graphData, int M, int N) {
        m = M;
        n = N;
        EdgeIndices = new int[n + 1][n + 1];
        this.adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++)
            this.adjacencyList[i] = new ArrayList<>();
        int edgeCount = 1;
        for (int[] edge : graphData) {
            this.addEdge(edge[0], edge[1], edgeCount++);
        }
    }

    public void printGraph() {
        for (int i = 1; i <= n; i++) {
            System.out.print(i);
            for (int c : adjacencyList[i])
                System.out.print(" -> " + c);
            System.out.println();
        }
    }

    public IncidenceMatrixGraph toIncidenceMatrixGraph() {
        IncidenceMatrixGraph incidenceMatrixGraph = new IncidenceMatrixGraph(m, n);
        for (int i = 1; i <= n; i++) {
            for (int u : adjacencyList[i])
                incidenceMatrixGraph.addEdge(i, u, EdgeIndices[i][u]);
        }
        return incidenceMatrixGraph;
    }
}
