package com.company.IO;

import java.io.*;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class TCPClientHandler implements Runnable {

    private final Socket connection;
    private static final int BUFFER_SIZE = 4096;
    Logger errorLogger;
    PrintWriter writer;
    BufferedReader reader;
    ArrayList<String> fileList;
    String dir;
    public TCPClientHandler(Socket conn, ArrayList<String> fileList, String dir) {
        this.connection = conn;
        this.fileList = fileList;
        this.dir = dir;
        errorLogger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    }

    private void writeFile(DataOutputStream dos, String filename) {
        File file = new File(dir + filename);
        try (FileInputStream fileInputStream = new FileInputStream(file)){
            byte[] buffer = new byte[BUFFER_SIZE];
            dos.writeLong(file.length());
            int bytes = 0;
            while ((bytes = fileInputStream.read(buffer)) != -1) {
                dos.write(buffer, 0, bytes);
                dos.flush();
            }
            fileInputStream.close();
            System.out.println("File successfully transferred");
        } catch (Exception e) {
            System.out.println("Exception occurred when writing file to client");
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            connection.setSoTimeout(10000);
            writer = new PrintWriter(connection.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String message;
            //receive initial "index"
            while ((message = reader.readLine()) != null) {
                System.out.println("Received message = " + message);
                if (message.equals("index")) { 
                    StringBuilder sb = new StringBuilder();
                    for (String filename : fileList) {
                        sb.append(filename + " ");
                    }
                    writer.println(sb.toString());
                    System.out.println("Message sent: " + sb.toString());
                } else { //get
                    String[] parts = message.split(" ");
                    if (!parts[0].equals("get") || parts.length < 2)
                        writer.println("Error(Wrong input format)");
                    else {
                        String filename = parts[1];
                        if (fileList.contains(filename)) {
                            writer.println("ok " + filename);
                            writer.flush();
                            //write file
                            writeFile(new DataOutputStream(connection.getOutputStream()), filename);
                        } else writer.println("Error(File not found)");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
