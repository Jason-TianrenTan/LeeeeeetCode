package com.company.Utils;

public class FileLineRetriever implements LineCountListener {

    @Override
    public void onLineCountEvent(int lines, String filename) {
        System.out.println(filename + ": " + lines);
    }

    public void work(String[] args) {
        for (String file : args) {
            FileThread fileThread = new FileThread(file, this);
            new Thread(fileThread).start();
        }
    }
}
