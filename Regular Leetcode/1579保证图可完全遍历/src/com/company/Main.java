package com.company;

public class Main {

    int[] rank_A = new int[100001], rank_B = new int[100001];
    int[] father_A = new int[100001], father_B = new int[100001];
    int setCount_A = 0, setCount_B = 0;

    public int find_A(int x) {
        if (father_A[x] == x)
            return x;
        father_A[x] = find_A(father_A[x]);
        return father_A[x];
    }

    public int find_B(int x) {
        if (father_B[x] == x)
            return x;
        father_B[x] = find_B(father_B[x]);
        return father_B[x];
    }

    public boolean merge_A(int i, int j) {
        int x = find_A(i), y = find_A(j);
        if (x == y)
            return false;
        if (rank_A[x] >= rank_A[y])
            father_A[y] = x;
        else father_A[x] = y;
        if (rank_A[x] == rank_A[y] && x != y)
            rank_A[x]++;
        setCount_A--;
        return true;
    }

    public boolean merge_B(int i, int j) {
        int x = find_B(i), y = find_B(j);
        if (x == y)
            return false;
        if (rank_B[x] >= rank_B[y])
            father_B[y] = x;
        else father_B[x] = y;
        if (rank_B[x] == rank_B[y] && x != y)
            rank_B[x]++;
        setCount_B--;
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {

        int ans = 0;
        setCount_A = setCount_B = n;
        //init
        for (int i=1;i<=n;i++) {
            rank_A[i] = rank_B[i] = 1;
            father_A[i] = father_B[i] = i;
        }
        for (int i=0;i<edges.length;i++) {
            int type = edges[i][0], u = edges[i][1], v = edges[i][2];
            if (type == 3) {
                if (!merge_A(u, v))
                    ans++;
                else
                    merge_B(u, v);
            }
        }

        for (int i=0;i<edges.length;i++) {
            int type = edges[i][0], u = edges[i][1], v = edges[i][2];
            if (type == 1 && !merge_A(u, v))
                ans++;
            if (type == 2 && !merge_B(u, v))
                ans++;
        }

        //check
        if (setCount_A > 1 || setCount_B > 1)
            return -1;
        return ans;
    }

    public void work() {
        int n = 4;
        int[][] edges = { {3,2,3}, {1,1,2}, {2,3,4}};
        System.out.println(maxNumEdgesToRemove(n, edges));
    }

    public static void main(String[] args) {
	// write your code here
        new Main().work();
    }
}
