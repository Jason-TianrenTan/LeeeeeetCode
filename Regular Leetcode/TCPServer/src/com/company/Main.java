package com.company;

import com.company.Data.FileData;
import com.company.IO.TCPServer;

public class Main {

    final static String INITIAL_DIR = "./files/";
    final static int PORT = 8086;
    public static void main(String[] args) {
	// write your code here
        FileData files = new FileData(INITIAL_DIR);
        new TCPServer(PORT, files).start();
    }
}
