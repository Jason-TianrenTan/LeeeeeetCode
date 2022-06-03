package com.company;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public class HelloWorldThread implements Runnable {

        private int id;
        private boolean active = true;

        public void stop() {
            this.active = false;
        }

        public HelloWorldThread(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            while (this.active) {
                long currentTime = System.nanoTime();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                System.out.println("Hello World! I'm thread " + this.id + ". The time is " + simpleDateFormat.format(new Date()) + "(" + currentTime + ")");
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    System.out.println("Thread was interrupted");
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean isNumber(String str) {
        Pattern pattern = Pattern.compile("[1-9][0-9]*");
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public void work() {
        int threadCount = 0;
        HashMap<Integer, HelloWorldThread> threadPool = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Here are your options:\n" +
                "\n" +
                "a - Create a new thread\n" +
                "b - Stop a given thread (e.g. \"b 2\" kills thread 2)\n" +
                "c - Stop all threads and exit this program\n");
        while (true) {
            String input = scanner.nextLine();
            //System.out.println("input = " + input);
            if (input.equals("a")) {
                HelloWorldThread thread = new HelloWorldThread(++threadCount);
                threadPool.put(threadCount, thread);
                new Thread(thread).start();
            } else if (input.startsWith("b")) {
                String[] parts = input.split(" ");
                if (parts.length < 2 || !isNumber(parts[1]))
                    System.out.println("Error input, try again");
                else {
                    int index = Integer.parseInt(parts[1]);
                    if (threadPool.containsKey(index)) {
                        threadPool.get(index).stop();
                        System.out.println("Thread " + index + " killed");
                    } else
                        System.out.println("Index out of range, try again");
                }
            } else if (input.equals("c"))
                System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Main().work();
    }
}
