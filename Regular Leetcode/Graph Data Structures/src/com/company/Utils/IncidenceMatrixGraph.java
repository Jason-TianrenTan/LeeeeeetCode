package com.company.Utils;

public class IncidenceMatrixGraph {

    int[][] incidenceMatrix;
    int[][] edges;
    int m, n;

    public IncidenceMatrixGraph(int M, int N) {
        m = M;
        n = N;
        incidenceMatrix = new int[n + 1][m + 1];
        edges = new int[m + 1][2];
    }

    public void addEdge(int v1, int v2, int edgeIndex) {
        incidenceMatrix[v1][edgeIndex] = 1;
        incidenceMatrix[v2][edgeIndex] = 1;
        edges[edgeIndex] = new int[]{v1, v2};
    }

    public IncidenceMatrixGraph(int[][] graphData, int M, int N) {
        this(M, N);
        for (int i=1;i<=m;i++) {
            int u = graphData[i-1][0], v = graphData[i-1][1];
            incidenceMatrix[u][i] = 1;
            incidenceMatrix[v][i] = 1;
            edges[i] = new int[]{u, v};
        }
    }

    public void printGraph() {
        for (int i=1;i<=n;i++) {
            for (int e=1;e<=m;e++)
                System.out.print(incidenceMatrix[i][e] + " ");
            System.out.println();
        }
    }

    public AdjacencyListGraph toAdjacencyListGraph() {
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(n);
        for (int i=1;i<=n;i++) {
            for (int e=1;e<=m;e++) {
                if (this.incidenceMatrix[i][e] > 0) {
                    int u = edges[e][0], v = edges[e][1];
                    adjacencyListGraph.addEdge(i, v == i ? u : v, e);
                }
            }
        }
        return adjacencyListGraph;
    }
}
