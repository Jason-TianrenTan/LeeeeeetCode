package com.company;

import com.company.Utils.*;

import java.util.ArrayList;
import java.io.*;

public class Main {

    static final String PRIDE_AND_PREJUDICE = "pride-and-prejudice.txt";
    static final int TEST_TIME = 1;
    /*considering that insertion and selection are too slow with large data sets,
    I chose to test 10 times instead of 100
     */
    public void testQuickSorter() {
        performTest(new QuickSorter());
    }

    public void testMergeSorter() {
        performTest(new MergeSorter());
    }

    public void testHeapSorter() {
        performTest(new HeapSorter());
    }

    public void testSelectionSorter() {
        performTest(new SelectionSorter());
    }

    public void testInsertionSorter() {
        performTest(new InsertionSort());
    }

    public void performTest(Sorter sorter) {
        String line;
        ArrayList<String> parseResult;
        ArrayList<String> words = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(PRIDE_AND_PREJUDICE));
            while ((line = reader.readLine()) != null) {
                parseResult = Parser.parseLine(line);
                for (String str : parseResult)
                    words.add(str);
            }
            String[] arr = words.toArray(new String[0]);
            //testing part
            double averageTime = 0;
            long bestTime = Long.MAX_VALUE;
            long worstTime = 0;
            for (int test = 0;test<TEST_TIME;test++) {
                String[] copy = new String[arr.length];//deep copy arr -> copy
                for (int i=0;i<arr.length;i++)
                    copy[i] = arr[i];
                long startTime = System.nanoTime();
                sorter.sort(copy);
                long endTime = System.nanoTime();
                long duration = endTime - startTime;
                averageTime += (double)duration / (double)TEST_TIME;
                bestTime = duration < bestTime ? duration : bestTime;
                worstTime = duration > worstTime ? duration : worstTime;
                
                for (String str : copy)
                    System.out.println(str);
                System.out.println("duration = " + duration);
            }
            System.out.println("Best Time: " + bestTime);
            System.out.println("Worst Time: " + worstTime);
            System.out.println("Average Time: " + averageTime);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void work() {
        testQuickSorter();
        //testMergeSorter();
        //testHeapSorter();
        //testSelectionSorter();
        //testInsertionSorter();
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
