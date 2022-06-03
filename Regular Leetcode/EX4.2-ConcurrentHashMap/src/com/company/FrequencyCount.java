package com.company;
/**
 * @author Crista Lopes
 * Simple word frequency program
 */

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import static com.company.StopWordsUtil.*;
public class FrequencyCount {

    static ExecutorService exec = Executors.newCachedThreadPool();
    static final class Counter {
        private ConcurrentHashMap<String, Integer> frequencies = new ConcurrentHashMap<>();

        private List<Map.Entry<String, Integer>> sort() {
            Set<Map.Entry<String, Integer>> set = frequencies.entrySet();
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
                    set);
            Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
                public int compare(Map.Entry<String, Integer> o1,
                                   Map.Entry<String, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
            return list;
        }

        public void update(String word) {
            synchronized (frequencies) {
                if (frequencies.containsKey(word))
                    frequencies.put(word, frequencies.get(word) + 1);
                else
                    frequencies.put(word, 1);
            }
        }

        private ConcurrentHashMap<String, Integer> getFrequencies() {
            return frequencies;
        }

        public void merge(Counter other) {
            other.getFrequencies().forEach((k, v) -> frequencies.merge(k, v, Integer::sum));
        }

        // Only the top 40 words that are 3 or more characters
        public String toString() {
            List<Map.Entry<String, Integer>> sortedMap = sort();
            StringBuilder sb = new StringBuilder("---------- Word counts (top 40) -----------\n");
            int i = 0;
            for (Map.Entry<String, Integer> e : sortedMap) {
                String k = e.getKey();
                if (k.length() >= 3) {
                    i++;
                    sb.append(k + ":" + e.getValue() + "\n");
                }
                if (i >= 40)
                    break;
            }
            return sb.toString();
        }

    }

    private static CountDownLatch countDownLatch;

    private static void countWords(Path p, Counter c) {
        System.out.println("Started " + p);
        exec.execute(new WordCounter(c, p, countDownLatch));
    }

    public static void main(String[] args) {

        loadStopWords();
        Counter c = new Counter();

        long start = System.nanoTime();
        try {
            List<Path> pathList = new ArrayList<>();
            try (Stream<Path> paths = Files.walk(Paths.get("."))) {
                paths.filter(p -> p.toString().endsWith(".txt"))
                        .forEach(p -> pathList.add(p));
            }
            countDownLatch = new CountDownLatch(pathList.size());
            for (Path path : pathList)
                countWords(path, c);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        long elapsed = end - start;

        System.out.println(c);
        System.out.println("Elapsed time: " + elapsed / 1000000 + "ms");

    }
}
