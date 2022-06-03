package com.company;

public class Main {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int[] target = new int[len];
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (grumpy[i] == 1)
                target[i] = customers[i];
            else ans += customers[i];
        }

        int change = 0, start = 0, maxChange = 0;
        for (int i = 0; i < X; i++)
            change += target[i];
        maxChange = change;
        for (int i = X; i < len; i++) {
            change += target[i];
            change -= target[i - X];
            maxChange = Math.max(change, maxChange);
        }
        return ans + maxChange;
    }

    public void work() {
        int[] customers = {2}, grumpy = {1};
        int X = 1;
        System.out.println(maxSatisfied(customers, grumpy, X));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
