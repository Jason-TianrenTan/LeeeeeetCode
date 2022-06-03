package com.company;

import java.util.Random;
import java.util.concurrent.*;

public class Main3 {

    private static final int PROCEDURE_COUNT = 15;
    private static volatile boolean S = false;//Semaphore

    private static int getRandomSleep(int BASE, int MAX_RANGE) {
        Random rand = new Random();
        return BASE + rand.nextInt(MAX_RANGE - BASE);
        //    return 500;
    }

    private static void nap(int millisecs) {
        try {
            Thread.sleep(millisecs);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addProc(HighLevelDisplay d) {

        // Add a sequence of addRow operations with short random naps.
        for (int i = 0; i < PROCEDURE_COUNT; i++) {
            synchronized (d) {
                d.addRow("AAAAAAAAAAAAAAAAAAAA\t" + i);
                d.addRow("BBBBBBBBBBBBBBBBBBBB\t" + i);
            }
            nap(getRandomSleep(200, 600));
        }
    }

    private static void deleteProc(HighLevelDisplay d) {

        // Add a sequence of deletions of row 0 with short random naps.
        while (true) {
            nap(100);//just to see clearer
            d.deleteRow(0);
            nap(getRandomSleep(2500, 2800));
        }
    }

    public static void main(String[] args) {
        final HighLevelDisplay d = new JDisplay2();

        new Thread() {
            public void run() {
                addProc(d);
            }
        }.start();


        new Thread() {
            public void run() {
                deleteProc(d);
            }
        }.start();

    }
}