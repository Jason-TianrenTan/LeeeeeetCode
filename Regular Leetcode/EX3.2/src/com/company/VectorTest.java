package com.company;

import java.util.Vector;
import java.util.concurrent.Semaphore;

public class VectorTest {

    private boolean running = true;
    private Vector<String> people = new Vector<String>();
    //Semaphore S = new Semaphore(1);

    private void addPerson() {
        String name = RandomUtils.randomString();
    //    System.out.println("Adding " + name);
        people.add(name);
    //    System.out.println("Added " + name);
    }

    private String getLast() {
        synchronized (people) {
            int lastIndex = people.size() - 1;
            if (lastIndex >= 0)
                return people.get(lastIndex);
            else return "";
        }
    }

    private void deleteLast() {

        synchronized (people) {
            int lastIndex = people.size() - 1;
            if (lastIndex >= 0) {
            //    System.out.println("delete " + people.get(lastIndex));
                people.remove(lastIndex);
            }
        }

    }

    public void run() {
        // Start getter thread
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setName("Getter");
                while (running) {
                    synchronized (people) {
                        String person = getLast();
                        System.out.println("Last: " + person);
                    }
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        // Start deleter thread
        new Thread(new Runnable() {
            public void run() {
                Thread.currentThread().setName("Deleter");
                while (running) {
                    deleteLast();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();

        // This thread adds entries
        for (int i = 0; i < 100; i++) {
            addPerson();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }
        running = false;
    }

    public static void main(String[] args) {
        VectorTest hm = new VectorTest();
        hm.run();
    }

}
