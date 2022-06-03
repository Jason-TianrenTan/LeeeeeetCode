package com.company;

import java.util.*;

public class Main {

    public int minSwapsCouples(int[] row) {
        boolean[] visited = new boolean[row.length];
        ArrayList<Integer> connect[] = new ArrayList[row.length/2];
        for (int i=0;i<row.length/2;i++)
            connect[i] = new ArrayList<>();
        for (int i=0;i<row.length;i+=2) {
            int left = row[i]/2, right = row[i+1]/2;
            if (left != right) {
                connect[left].add(right);
                connect[right].add(left);
            }
        }
        int n = 0;
        for (int i=0;i<row.length/2;i++) {
            if (!visited[i]) {
                n++;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (queue.size() > 0) {
                    int top = queue.peek();
                    queue.poll();
                    for (int x : connect[top]) {
                        if (!visited[x]) {
                            visited[x] = true;
                            queue.add(x);
                        }
                    }
                }
            }
        }
        return row.length/2- n;
    }

    public void work() {
        int[] row = {3,1,0,2};
        System.out.println(minSwapsCouples(row));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
