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
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collections;
import java.util.Map;

import static com.company.StopWordsUtil.*;
public class FrequencyCount {

    static Executor exec;
    static CompletionService<Counter> completionService;
    static int tasks = 0;

    static final class Counter {
        private Map<String, Integer> frequencies = new HashMap<>();

        private List<Map.Entry<String, Integer>> sort() {
            Set<Map.Entry<String, Integer>> set = frequencies.entrySet();
            List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(
                    set);
            Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
            return list;
        }

        private Map<String, Integer> getFrequencies() {
            return frequencies;
        }

        public void update(String w) {
            frequencies.putIfAbsent(w, 0);
            frequencies.put(w, frequencies.get(w) + 1);
        }

        public void merge(Counter other) {
            other.getFrequencies().forEach((k, v) -> frequencies.merge(k, v, Integer::sum));
        }

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

    private static void countWords(Path p, Counter c) {
        System.out.println("Started " + p);
        completionService.submit(new WordCounter(c, p));
        tasks++;
    }

    public static void main(String[] args) {

        loadStopWords();
        exec = Executors.newCachedThreadPool();
        completionService = new ExecutorCompletionService<>(exec);
        long start = System.nanoTime();
        try {
            try (Stream<Path> paths = Files.walk(Paths.get("."))) {
                paths.filter(p -> p.toString().endsWith(".txt"))
                        .forEach(p -> {
                            countWords(p, new Counter());
                        });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //join maps
        Counter result = new Counter();
        try {
            for (int i = 0; i< tasks; i++) {
                Future<Counter> future = completionService.take();
                Counter mergeCounter = future.get();
                result.merge(mergeCounter);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        long end = System.nanoTime();
        long elapsed = end - start;
        System.out.println(result);
        System.out.println("Elapsed time: " + elapsed / 1000000 + "ms");

    }
}
