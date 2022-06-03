import java.util.*;

public class Main {

    int[] root, rank;
    List<Edge> edges;

    class Edge {
        int u, v, dist;

        public Edge(int st, int ed, int weight) {
            u = st;
            v = ed;
            dist = weight;
        }
    }

    int find(int x) {
        return x == root[x] ? x : (root[x] = find(root[x]));
    }

    boolean union(int x, int y) {
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

    //Kruskal's Algorithm of Minimum Spanning Tree
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        int totalCost = 0;
        root = new int[n + 1];
        rank = new int[n + 1];
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            root[i + 1] = i + 1;
            edges.add(new Edge(0, i + 1, wells[i]));
        }
        for (int[] pipe : pipes)
            edges.add(new Edge(pipe[0], pipe[1], pipe[2]));

        Collections.sort(edges, Comparator.comparingInt(e -> e.dist));
        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                totalCost += e.dist;
            }
        }

        return totalCost;
    }

    public void work() {
        int[] wells = {1,2,3,100,1000};
        int[][] pipes = {
                {1, 2, 1},
                {3, 4, 101},
                {4, 5, 898}
        };
        System.out.println(minCostToSupplyWater(5, wells, pipes));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
