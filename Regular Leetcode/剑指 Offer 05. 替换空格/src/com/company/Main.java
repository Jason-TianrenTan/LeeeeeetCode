package com.company;

public class Main {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<s.length();i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public void work() {

    }

    public static void main(String[] args) {
        new Main().work();
    }
}
