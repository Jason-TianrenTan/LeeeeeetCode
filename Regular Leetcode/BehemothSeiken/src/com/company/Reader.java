package com.company;
import java.io.*;
import java.util.ArrayList;

public class Reader {

    public ArrayList<Record> records;

    public Reader() {
        records = new ArrayList<>();
    }

    public void read() {
        try {
            File file = new File("records.txt");
            if (!file.exists())
                file.createNewFile();
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = null;
            while ((line = reader.readLine()) != null) {
                records.add(new Record(line));
            }
            reader.close();
        }  catch (Exception e) {
            e.printStackTrace();
        }
    }

}
