package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StopWordsUtil {

    public static final List<String> stop_words = new ArrayList<String>();

    public static void loadStopWords() {
        String str = "";
        try {
            byte[] encoded = Files.readAllBytes(Paths.get("stop_words"));
            str = new String(encoded);
        } catch (IOException e) {
            System.out.println("Error reading stop_words");
        }
        String[] words = str.split(",");
        stop_words.addAll(Arrays.asList(words));
    }
}
