package com.company;

import com.company.Utils.AdjacencyListGraph;
import com.company.Utils.AdjacencyMatrixGraph;
import com.company.Utils.IncidenceMatrixGraph;

public class Main {

    /**
     * N = 5 (vertices)
     * M = 7 (edges)
     */
    final static int N = 5, M = 7;

    int GraphData[][] = {
            {1,2},
            {2,3},
            {1,5},
            {2,5},
            {3,4},
            {4,5},
            {4,2}
    };

    /**
     * adjacency matrix -> adjacency list
     * Time Complexity: O(n^2), since we need to traverse half of the nxn matrix
     */
    public void AdjMatrix2AdjList() {
        AdjacencyMatrixGraph adjacencyMatrixGraph = new AdjacencyMatrixGraph(GraphData, M, N);
        AdjacencyListGraph AMatrixToListGraph = adjacencyMatrixGraph.toAdjacencyListGraph();
        AMatrixToListGraph.printGraph();
        //in compare to check
        System.out.println();
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(GraphData, M ,N);
        adjacencyListGraph.printGraph();
    }

    /**
     * adjacency list -> incidence matrix
     * Time Complexity: O(m+n), since we traverse the whole adjacency list
     */
    public void AdjList2IncidenceMatrix() {
        //adjacency list to incidence matrix
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(GraphData, M, N);
        IncidenceMatrixGraph AListToIMatrixGraph = adjacencyListGraph.toIncidenceMatrixGraph();
        AListToIMatrixGraph.printGraph();
        //in compare to check
        System.out.println();
        IncidenceMatrixGraph incidenceMatrixGraph = new IncidenceMatrixGraph(GraphData, M, N);
        incidenceMatrixGraph.printGraph();
    }

    /**
     * Incidence matrix -> adjacency list
     * Time Complexity: O(nm), since there are n vertices time m edges.
     */
    public void IncidenceMatrix2AdjList() {
        IncidenceMatrixGraph incidenceMatrixGraph = new IncidenceMatrixGraph(GraphData, M, N);
        AdjacencyListGraph IncMatrix2AdjList = incidenceMatrixGraph.toAdjacencyListGraph();
        IncMatrix2AdjList.printGraph();
        //in compare to check
        System.out.println();
        AdjacencyListGraph adjacencyListGraph = new AdjacencyListGraph(GraphData, M, N);
        adjacencyListGraph.printGraph();
    }

    public void work() {
     //   AdjMatrix2AdjList();

     //   AdjList2IncidenceMatrix();

        IncidenceMatrix2AdjList();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
