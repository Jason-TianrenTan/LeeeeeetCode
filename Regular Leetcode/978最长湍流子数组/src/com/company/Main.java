package com.company;

public class Main {

    public int maxTurbulenceSize(int[] arr) {
        int[] comp = new int[arr.length - 1];
        boolean allZero = true;
        for (int i=0;i<arr.length - 1;i++) {
            comp[i] = Integer.compare(arr[i], arr[i + 1]);
            if (comp[i] != 0)
                allZero = false;
        }
        if (allZero)
            return 1;
        int[] f = new int[arr.length - 1];
        for (int i=0;i<arr.length-1;i++)
            f[i] = 1;
        int maxlen = 1;
        for (int i=1;i<arr.length - 1;i++) {
            if (comp[i] * comp[i-1] < 0) {
                f[i] = f[i-1] + 1;
                maxlen = maxlen > f[i] ? maxlen : f[i];
            }
            maxlen = maxlen > f[i] ? maxlen : f[i];
        }
        return maxlen + 1;
    }

    public void work() {
        int[] arr = {1};
        System.out.println(maxTurbulenceSize(arr));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
