package com.company;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// The tutorial can be found just here on the SSaurel's Blog : 
// https://www.ssaurel.com/blog/create-a-simple-http-web-server-in-java
// Each Client Connection will be managed in a dedicated Thread
import static com.company.WebConfig.*;
public class WebServer {

    // Client Connection via Socket Class
    private Socket connect;

    public WebServer(Socket c) {
        connect = c;
    }


    public static void main(String[] args) {
        try {
            ExecutorService webExec = Executors.newCachedThreadPool();
            ServerSocket serverConnect = new ServerSocket(PORT);
            System.out.println("Server started.\nListening for connections on port : " + PORT + " ...\n");

            // we listen until user halts server execution
            while (true) {
                WebServer myServer = new WebServer(serverConnect.accept());
                if (verbose) {
                    System.out.println("Connection opened. (" + new Date() + ")");
                }
                webExec.execute(new ClientHandler(myServer.connect, verbose));
            }

        } catch (IOException e) {
            System.err.println("Server Connection error : " + e.getMessage());
        }
    }



}
