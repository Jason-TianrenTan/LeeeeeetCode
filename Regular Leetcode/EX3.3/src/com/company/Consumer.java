package com.company;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

    public static volatile int producers;
    private BlockingQueue<Message> queue;
    private int id;

    public Consumer(BlockingQueue<Message> q, int n) {
        queue = q;
        id = n;
    }

    public void run() {
        Message msg = null;
        int count = 0;
        while (producers > 0 || !queue.isEmpty()) {
            try {
                msg = queue.poll(100, TimeUnit.MILLISECONDS); // Get a message from the queue
                if (msg != null) {
                    if (!msg.get().equals("stop")) {
                        count++;
                        RandomUtils.print("Consumed " + msg.get(), id);
                        Thread.sleep(RandomUtils.randomInteger());
                    } else producers--;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        RandomUtils.print("Messages received: " + count, id);
    }
}
