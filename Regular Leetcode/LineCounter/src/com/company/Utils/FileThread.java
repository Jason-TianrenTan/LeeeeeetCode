package com.company.Utils;
import java.io.*;
import java.util.*;
public class FileThread implements Runnable{

    int lineCount;
    String filename;
    BufferedReader reader;
    LineCountListener listener;
    public FileThread(String fname, LineCountListener l) {
        this.filename = fname;
        this.listener = l;
    }

    @Override
    public void run() {
        //String line;
        int c = -1;
        try {
            reader = new BufferedReader(new FileReader(filename));
            /*
            while ((line = reader.readLine()) != null) {
                lineCount++;
                System.out.println(lineCount + " : " + line);
            }*/
            while ((c = reader.read()) != -1) {
                if ((char)c == '\n')
                    lineCount++;
            }
            lineCount++;//For blank text files, I set the count = 1
            reader.close();
            listener.onLineCountEvent(lineCount, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
