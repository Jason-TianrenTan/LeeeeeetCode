package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

import static com.company.StopWordsUtil.*;
import static com.company.FrequencyCount.*;

public class WordCounter implements Callable<Counter> {

    private Path filepath;
    private Counter counter;

    public WordCounter(Counter c, Path filepath) {
        this.filepath = filepath;
        this.counter = c;
    }

    private void process(Path filepath) {
        try {
            try (Stream<String> lines = Files.lines(filepath /*Paths.get(filename)*/)) {
                lines.forEach(line -> process(line));
            }
            System.out.println("Ended " + filepath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Keep only the non stop words with 3 or more characters
    private void process(String line) {
        String[] words = line.split("\\W+");
        for (String word : words) {
            String w = word.toLowerCase();
            if (!stop_words.contains(w) && w.length() > 2) {
                counter.update(w);
            }
        }
    }

    @Override
    public Counter call() throws Exception {
        process(filepath);
        return counter;
    }
}
