package com.company;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.DataTruncation;
import java.util.*;
import java.net.Socket;
public class TCPClient {

    static final int BUFFER_SIZE = 4096;
    String address;
    int port;
    String dir = "./files/";
    public TCPClient(String address, int port) {
        this.address = address;
        this.port = port;
    }

    public void downloadFile(DataInputStream in, String filename) {
        try {
            //Checking files
            File directory = new File(dir);
            if (!directory.exists() || !directory.isDirectory())
                directory.mkdir();
            File file = new File(dir + filename);
            file.createNewFile();

            FileOutputStream fos = new FileOutputStream(file);
            long fileSize = in.readLong();
            int bytesRead = 0;
            byte[] buffer = new byte[BUFFER_SIZE];
            while (fileSize > 0 && (bytesRead = in.read(buffer, 0, (int)(BUFFER_SIZE > fileSize ? fileSize : BUFFER_SIZE))) != -1) {
                fos.write(buffer, 0, bytesRead);
                fileSize -= bytesRead;
            }
            fos.close();
            System.out.println("File successfully saved");
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getFileName(String response) {
        String[] parts = response.split(" ");
        return parts[1];
    }

    public void start() {
        try (Socket socket = new Socket(address, port)) {
            socket.setSoTimeout(10000);
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            InputStream socketInputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(socketInputStream));
            //get index
            writer.println("index");
            String index_response = reader.readLine();
            System.out.println("Message from server: " + index_response);
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Input query: ");
                String input = scanner.nextLine();
                writer.println(input);
                String response = reader.readLine();
                if (response.startsWith("ok")) {
                    System.out.println("Downloading file...");
                    downloadFile(new DataInputStream(socketInputStream), getFileName(response));
                } else System.out.println("Message from server: "  + response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
