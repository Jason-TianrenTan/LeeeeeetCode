package com.company.Data;

import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.util.logging.Logger;

public class FileData {

    private ArrayList<String> fileList;
    private String directory;

    public String getDir() {
        return this.directory;
    }

    public boolean setDir(String dir) {
        if (!dir.endsWith("/"))
            dir += "/";
        System.out.println("Fetching files from directory...");
        this.directory = dir;
        return initialize();
    }

    public ArrayList<String> getFiles() {
        return this.fileList;
    }

    public FileData(String dir) {
        fileList = new ArrayList<>();
        this.directory = dir;
    }

    public boolean initialize() {
        fileList = new ArrayList<>();
        File dir = new File(directory);
        try {
            if (!dir.exists() || !dir.isDirectory())
                dir.mkdir();
            System.out.println(dir.getAbsolutePath());
            File[] files = dir.listFiles();
            System.out.println(files.length + " files were found");
            for (File file : files) {
                if (!file.isDirectory()) {
                    fileList.add(file.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
