package com.company.Utils;
public class HashTable {

    HashNode[] buckets;
    int bucketSize = 16;//2e4
    int size = 0;
    double loadFactor = 0;

    private class HashNode {
        int hashcode;
        String key;
        Object value;
        HashNode next;

        public HashNode(String key, Object value) {
            this.key = key;
            this.hashcode = getHashCode(this.key);
            this.value = value;
            this.next = null;
        }

        public HashNode() {
            this.next = null;
        }

    }

    public static int getHashCode(String word) {
        return word.hashCode() & 0xfffffff;//remove sign bit, can't use ABS since it will return negative if hashcode equals Integer.MIN_VALUE
    }

    public HashTable() {
        buckets = new HashNode[bucketSize];
    }

    /**
    private void printBuckets(HashNode[] buckets) {
        for (int i=0;i<bucketSize;i++) {
            HashNode head = buckets[i];
            System.out.println("Index " + i);
            if (head != null) {
                HashNode current = head.next;
                while (current != null) {
                    System.out.print(current.key + " ");
                    current = current.next;
                }
                System.out.println();
            }
        }
    }*/
    
    private boolean bucketAdd(HashNode[] buckets, HashNode node) {
        int index = node.hashcode % bucketSize;
        if (buckets[index] == null)
            buckets[index] = new HashNode();//initial node in each bucket is empty
        HashNode current = buckets[index];
        while (current.next != null) {
            current = current.next;
            if (current.key != null && current.key.equals(node.key))
                return false;
        }
        current.next = node;
        this.size++;
        this.loadFactor = (double)size / (double)bucketSize;
        return true;
    }

    private void rehash() {
        size = 0;
        bucketSize *= 2;
        HashNode[] newBuckets = new HashNode[bucketSize];
        for (int i = 0; i < bucketSize / 2; i++) {
            HashNode head = buckets[i];
            if (head != null) {
                HashNode node = head.next;
                while (node != null) {
                    this.bucketAdd(newBuckets, new HashNode(node.key, node.value));
                    node = node.next;
                }
            }
        }
        this.buckets = newBuckets;
    }

    public boolean add(String key, Object value) {
        boolean result = this.bucketAdd(this.buckets, new HashNode(key, value));
        if (result && this.loadFactor > 0.75) //keep load factor below 0.75
            this.rehash();;
        return result;
    }

    public boolean containsKey(String key) {
        //Traverse the bucket
        int index = getHashCode(key) % bucketSize;
        HashNode node = buckets[index];
        if (node == null)
            return false;
        while (node.next != null) {
            node = node.next;
            if (node.key.equals(key))
                return true;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

}
