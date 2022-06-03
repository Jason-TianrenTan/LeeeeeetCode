package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public void work() {
        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 2);
    }
    public static void main(String[] args) {
        new Main().work();
    }

    class LRUCache {

        Map<Integer, LRUNode> map;
        int capacity;
        LRUNode head, tail;
        public LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head = new LRUNode(-1, 0);
            tail = new LRUNode(-2, 0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                moveToTail(map.get(key));
                return map.get(key).value;
            }
            return -1;
        }

        public void moveToTail(LRUNode node) {
            System.out.println("Moving " + node.key + " to tail, previous tail = " + tail.prev);
            tail.prev.next = node;
            node.prev = tail.prev;
            node.next = tail;
            tail.prev = node;
        }

        private void print() {
            System.out.println("Nodes: ");
            LRUNode node = head;
            while (node != null) {
                System.out.println(node.toString());
                node = node.next;
            }
            System.out.println("Map: ");
            for (Map.Entry<Integer, LRUNode> entry : map.entrySet())
                System.out.println(entry.getKey() + ", " + entry.getValue());
        }
        public void put(int key, int value) {
            System.out.println("Put " + key + ", " + value);
            LRUNode node;
            if (map.containsKey(key)) {
                node = map.get(key);
                //move to tail
                node.value = value;
                node.prev.next = node.next;
                node.next.prev = node.prev;
            } else {
                node = new LRUNode(key, value);
                if (map.size() == capacity) {
                    LRUNode first = head.next;
                    map.remove(first.key);
                    System.out.println("Remove Node [" + first.key + ", " + first.value + "]");
                    head.next = first.next;
                    first.next.prev = head;
                }
                map.put(key, node);
            }
            moveToTail(node);
            print();
        }

        class LRUNode {
            int key;
            int value;
            LRUNode next, prev;
            public LRUNode() {}
            public LRUNode(int k, int v) {
                this.key = k;
                this.value = v;
            }
            public String toString() {
                return "[" + this.key + ", " + this.value + "], prev = " + (this.prev == null ? null : this.prev.key) + ", next = " + (this.next == null ? null : this.next.key);
            }
        }
    }
}
