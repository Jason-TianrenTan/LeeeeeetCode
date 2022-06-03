package com.company.IO;
import com.company.Data.FileData;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class TCPServer {

    Logger errorLogger;
    int port;
    ServerSocket socket;
    FileData fileData;
    public TCPServer(int port, FileData fileData) {
        errorLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        this.port = port;
        this.fileData = fileData;
    }
    
    private void printFiles() {
        ArrayList<String> filenames = fileData.getFiles();
        for (String filename : filenames)
            System.out.println(filename);
        System.out.println();
    }
    
    public void start() {
        try {
            //configure
            System.out.println("Server file location: " + this.fileData.getDir());
            boolean configured = false;
            while (!configured) {
                System.out.print("Do you wish to change location?(Y/N)\t");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("Y")) {
                    System.out.print("Please input new directory: ");
                    String nDir = scanner.nextLine();
                    configured = fileData.setDir(nDir);
                } else if (!input.equals("N")) {
                    System.out.println("Illegal input, please try again");
                } else {
                    configured = true;
                    fileData.initialize();
                }
            }
            socket = new ServerSocket(this.port);
            System.out.println("Server started at " + socket.getInetAddress() + ":" + this.port);
            printFiles();
            while (true) {
                Socket client_connection = socket.accept();
                System.out.println("Accepted new client address: " + client_connection.getInetAddress());
                new Thread(new TCPClientHandler(client_connection, fileData.getFiles(), fileData.getDir())).start();
            }
        } catch (IOException e) {
            errorLogger.log(Level.SEVERE, "Server fatal error : ", e);
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    errorLogger.log(Level.WARNING, "Server was not correctly closed", e);
                    e.printStackTrace();
                }
            }
        }
    }

}
