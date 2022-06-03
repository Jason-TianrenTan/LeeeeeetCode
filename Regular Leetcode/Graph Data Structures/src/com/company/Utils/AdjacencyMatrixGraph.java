package com.company.Utils;

public class AdjacencyMatrixGraph {
    
    private int n, m;
    private int[][] matrix;
    public AdjacencyMatrixGraph(int[][] graphData, int M, int N) {
        m = M;
        n = N;
        matrix = new int[n + 1][n + 1];//assuming all numbers from 1~n
        for (int i=1;i<=graphData.length;i++)
            matrix[graphData[i-1][0]][graphData[i-1][1]] = matrix[graphData[i-1][1]][graphData[i-1][0]] = i;
    }
    
    public void printGraph() {
        for (int i=1;i<=n;i++) {
            for (int j=1;j<=n;j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }
    }

    public AdjacencyListGraph toAdjacencyListGraph() {
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(n);
        for (int i=1;i<=n;i++) {
            for (int j=1;j<i;j++) {
                if (this.matrix[i][j] > 0)
                    adjacencyListGraph.addEdge(i, j, matrix[i][j]);
            }
        }
        return adjacencyListGraph;
    }
}
