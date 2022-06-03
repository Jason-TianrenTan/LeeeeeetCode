package com.company;

import java.util.ArrayList;

public class Main {

    int[][] Heights;
    int row, col;
    ArrayList<Integer> adjacent[];

    public int distance(int x, int y, int nx, int ny) {
        return Math.abs(Heights[x][y] - Heights[nx][ny]);
    }

    int max(int a, int b) { return a > b ? a : b; }

    int edge(int u, int v) {
        int i1 = u / col, j1 = u % col;
        int i2 = v / col, j2 = v % col;
        return distance(i1, j1, i2, j2);
    }

    public void find(int x, int y) {
        if (x < row - 1) {
            adjacent[x * col + y].add((x + 1) * col + y);
        }
        if (x > 0) {
            adjacent[x * col + y].add((x - 1) * col + y);
        }
        if (y < col - 1) {
            adjacent[x * col + y].add(x * col + y + 1);
        }
        if (y > 0) {
            adjacent[x * col + y].add(x * col + y - 1);
        }
    }


    public int minimumEffortPath(int[][] heights) {
        Heights = heights;
        row = heights.length;
        col = heights[0].length;
        int N = row * col;
        adjacent = new ArrayList[N];
        int[] dist = new int[N];
        boolean[] visited = new boolean[N];
        for (int i=0;i<row;i++)
            for (int j=0;j<col;j++)
                adjacent[i * col + j] = new ArrayList<>();
        for (int i=0;i<row;i++) {
            for (int j = 0; j < col; j++) {
                find(i, j);
                dist[i * col + j] = 1000001;
                visited[i * col + j] = false;
            }
        }

        for (int u : adjacent[0])
            dist[u] = edge(0, u);

        dist[0] = 0;
        visited[0] = true;
//        int[] Path = new int[N];
//        Path[0] = -1;
        for (int i=0;i<N;i++) {
            int min = 1000001, p = 0;
            for (int u = 0; u < N;u++) {
                if (dist[u] < min && !visited[u]) {
                    min = dist[u];
                    p = u;
                }
            }
            visited[p] = true;
            for (int u : adjacent[p]) {
                if (!visited[u] && dist[u] > max(dist[p], edge(p, u))) {
                    dist[u] = max(dist[p], edge(p, u));
                 //   Path[u] = p;
                }
            }
        }

//        int F = N - 1;
//        System.out.println(row + ", " + col);
//        while (F != -1) {
//            System.out.println(F+ ", " + F/col + "," + F%col + " {" + heights[F/col][F%col] + "}");
//            F = Path[F];
//        }
        return dist[N - 1];
    }

    public void work() {
        int[][] heights =
                        {
                                {1,2,1,11,12},
                                {1,2,31,2,1},
                                {1,2,11,2,1},
                                {1,2,11,2,1},
                                {1,1,11,2,1}};
        System.out.println(minimumEffortPath(heights));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
