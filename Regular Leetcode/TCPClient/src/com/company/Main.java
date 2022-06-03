package com.company;

public class Main {

    static final String ADDRESS = "127.0.0.1";
    static final int PORT = 8086;
    public static void main(String[] args) {
        new TCPClient(ADDRESS, PORT).start();
    }
}
