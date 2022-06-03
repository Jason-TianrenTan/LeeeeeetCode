package com.company;

public class Main {

    public int translateNum(int num) {
        if (num == 0)
            return 1;
        int n1 = num % 10;
        num /= 10;
        int ans = translateNum(num);
        if (num > 0) {
            int n2 = num % 10;
            int comb = n2 * 10 + n1;
            if (n2 > 0 && comb < 26)
                ans += translateNum(num / 10);
        }
        return ans;
    }

    public void work() {
        int num = 5000027;
        System.out.println(translateNum(num));
    }

    public static void main(String[] args) {
        new Main().work();
    }

}
