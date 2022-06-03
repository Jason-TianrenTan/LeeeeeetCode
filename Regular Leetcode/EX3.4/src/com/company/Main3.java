package com.company;

import java.util.Random;
import java.util.concurrent.*;

public class Main3 {

    private static final int BASE_SLEEP_TIME = 200;
    private static final int PROCEDURE_COUNT = 15;
    private static Semaphore S;

    private static int getRandomSleep(int MAX_RANGE) {
        Random rand = new Random();
        return BASE_SLEEP_TIME + rand.nextInt(MAX_RANGE - BASE_SLEEP_TIME);
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
            try {
                S.acquire();
                d.addRow("AAAAAAAAAAAAAAAAAAAA\t" + i);
                d.addRow("BBBBBBBBBBBBBBBBBBBB\t" + i);
                S.release();
                nap(getRandomSleep(900));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    private static void deleteProc(HighLevelDisplay d) {

        // Add a sequence of deletions of row 0 with short random naps.
        while (true) {
            try {
                S.acquire();
                d.deleteRow(0);
                S.release();
                nap(getRandomSleep(1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        final HighLevelDisplay d = new JDisplay2();
        S = new Semaphore(1);
        new Thread(() -> addProc(d)).start();
        new Thread(() -> deleteProc(d)).start();
    }
}