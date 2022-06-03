package com.company;

import com.company.Sets.BSTreeSet;
import com.company.Sets.HashTableSet;
import com.company.Sets.LinkedListSet;
import com.company.Utils.DataStructureSet;
import com.company.Utils.LinkedList;
import com.company.Utils.Parser;

import java.io.*;
import java.util.ArrayList;

public class Main {

    static final String PRIDE_AND_PREJUDICE = "pride-and-prejudice.txt",
            WORDS_SHUFFLED = "words-shuffled.txt",
            TEST = "test.txt";
    BufferedReader reader = null, shuffled_reader = null;
    static final int testTime = 1000;
    long[] plots = new long[8000];
    double _BestTime = 0, _AverageTime = 0, _WorstTime = 0;

    public void testLinkedListSet() throws IOException {
        for (int i=0;i<testTime;i++) {
            LinkedListSet input = new LinkedListSet();
            insertData(input);
        }
    }

    public void testHashTableSet() throws IOException {
        for (int i=0;i<testTime;i++) {
            HashTableSet input = new HashTableSet();
            insertData(input);
        }
    }

    public void testBSTreeSet() throws IOException {
        for (int i=0;i<testTime;i++) {
            BSTreeSet input = new BSTreeSet();
            insertData(input);
        }
    }

    public void insertData(DataStructureSet input) throws IOException {
        reader = new BufferedReader(new FileReader(PRIDE_AND_PREJUDICE));
        shuffled_reader = new BufferedReader(new FileReader(WORDS_SHUFFLED));
        String line = null;
        LinkedList parseResult;
        LinkedList search = new LinkedList();
        //input
        while ((line = reader.readLine()) != null) {
            parseResult = Parser.parseLine(line);
            //Traverse parse result and add each word
            LinkedList.ListNode head = parseResult.getHead();
            while (head != null) {
                long start = System.nanoTime();
                boolean result = input.add(head.getVal());
                long end = System.nanoTime();
                if (result) {
                    plots[input.size()] += end - start;
                }
                //    words.add(head.getVal());
                head = head.getNext();
            }
        }

        //search
        while ((line = shuffled_reader.readLine()) != null) {
            parseResult = Parser.parseLine(line);
            //Traverse parse result and add each word
            LinkedList.ListNode head = parseResult.getHead();
            while (head != null) {
                search.add(head.getVal());
                head = head.getNext();
            }
        }


        double sum = 0;
        long bestTime = Long.MAX_VALUE, worstTime = 0;
        LinkedList.ListNode head = search.getHead();
        LinkedList.ListNode current = head;
        while (current != null) {
            long startTime = System.nanoTime();
            input.contains(current.getVal());
            long endTime = System.nanoTime();
            long duration = endTime - startTime;
            if (duration > worstTime)
                worstTime = duration;
            if (duration < bestTime)
                bestTime = duration;
            sum += duration;
            current = current.getNext();
        }
        double averageTime = sum / (double) search.getSize();
        _BestTime += (double)bestTime / (double)testTime;
        _WorstTime += (double)worstTime / (double)testTime;
        _AverageTime += averageTime / (double)testTime;
    }


    public void work() {
        try {
            //testLinkedListSet();
            //testHashTableSet();
            testBSTreeSet();
            System.out.println("Best Time = " + _BestTime + "\nWorst Time = " + _WorstTime + "\nAverage = " + _AverageTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
