package com.company;

public class Main {

    public int countEven(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int x = i;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            if (sum % 2 == 0)
                count++;
        }
        return count;
    }

    public void work() {
        System.out.println(countEven(2));
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
