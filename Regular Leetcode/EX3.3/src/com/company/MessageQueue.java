package com.company;

import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageQueue {
    private static int n_ids;

    public static void main(String[] args) {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>(20);
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt(), N = scanner.nextInt();
        List<Producer> producerPool = new ArrayList<>();
        Consumer.producers = M;
        for (int i = 0; i < M; i++) {
            Producer producer = new Producer(queue, n_ids++);
            producerPool.add(producer);
            new Thread(producer).start();
        }

        for (int j = 0; j < N; j++) {
            new Thread(new Consumer(queue, n_ids++)).start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //stop all
        for (Producer p : producerPool) {
            p.stop();
        }
    }
}
