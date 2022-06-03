package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public void work() {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(4);
        System.out.println(finder.findMedian());
    }

    public static void main(String[] args) {
        new Main().work();
    }

    class MedianFinder {

        private PriorityQueue<Integer> large, small;
        public MedianFinder() {
            large = new PriorityQueue<>();
            small = new PriorityQueue<>(Comparator.comparingInt(e -> -e));
        }

        public void addNum(int num) {
            small.add(num);
            large.add(small.poll());
            if (small.size() < large.size())
                small.add(large.poll());
        }

        public double findMedian() {
            if (small.size() -large.size() == 1)
                return small.peek();
            return (small.peek() + large.peek()) / 2.0;
        }
    }
}
