package com.company;

public class Main {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;
        while (tickets[k] > 0) {
            int time = 0;
            for (int i=0;i<tickets.length;i++) {
                if (tickets[i] > 0) {
                    tickets[i]--;
                    time++;
                    if (i == k && tickets[i] == 0)
                        return total + time;
                }
            }
            total += time;
        }
        return total;
    }

    public void work() {
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
