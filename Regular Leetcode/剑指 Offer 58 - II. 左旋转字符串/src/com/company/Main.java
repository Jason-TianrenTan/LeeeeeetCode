package com.company;

public class Main {

    public String reverseLeftWords(String s, int n) {
        String front = s.substring(0, n), back = s.substring(n, s.length());
        return back + front;
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
