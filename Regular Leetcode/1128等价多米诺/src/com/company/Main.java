package com.company;

public class Main {

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int i=0;i<dominoes.length;i++) {
            if (dominoes[i][0] >= dominoes[i][1]) {
                int tmp = dominoes[i][0];
                dominoes[i][0] = dominoes[i][1];
                dominoes[i][1] = tmp;
            }
        }
        qsort(dominoes, 0, dominoes.length - 1);
        int total = 0;
        int current = 1;
        for (int i=1;i<dominoes.length;i++) {
            if (dominoes[i][0] == dominoes[i - 1][0] && dominoes[i][1] == dominoes[i - 1][1])
                current++;
            else {
                total += current * (current - 1)/2;
                current = 1;
            }
        }
        total += current * (current - 1)/2;
        return total;
    }

    public void work() {
        int[][] dominoes = {{1,2}, {1, 2}, {1,1}, {1,2}, {2,2}, {2,2}, {3,4}, {4,3}};
        System.out.println(numEquivDominoPairs(dominoes));
    }

    public static void main(String[] args) {
	// write your code here
        new Main().work();
    }

    public int compare(int[] d1, int[] d2) {
        if (d1[0] >= d2[0]) {
            return d1[1] - d2[1];
        }
        return -1;
    }

    public void qsort(int[][] dominoes, int l, int r) {
        if (l < r) {
            int[] key = dominoes[l];
            int i = l, j = r;
            while (i < j) {
                while (i < j && compare(dominoes[j], key)>=0)
                    j--;
                if (i < j)
                    dominoes[i++] = dominoes[j];

                while (i < j && compare(dominoes[i], key) < 0)
                    i++;
                if (i < j)
                    dominoes[j--] = dominoes[i];
            }
            dominoes[i] = key;
            qsort(dominoes, l, i - 1);
            qsort(dominoes, i + 1, r);
        }
    }
}
