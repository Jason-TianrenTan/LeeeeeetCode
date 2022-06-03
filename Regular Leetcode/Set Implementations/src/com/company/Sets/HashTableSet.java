package com.company.Sets;

import com.company.Utils.DataStructureSet;
import com.company.Utils.HashTable;


public class HashTableSet extends DataStructureSet {
    /**
     * This code takes reference from https://www.geeksforgeeks.org/internal-working-of-sethashset-in-java/
     * I was wondering how internal sets worked for java so I looked it up. The explanation was interesting,
     * so I reconstructed one based on my understandings.
     */
    private HashTable hashTable;
    private static final Object PRESENT = new Object();//The dummy to interact with the internal hashmap

    public HashTableSet() {
        this.hashTable = new HashTable();
    }

    @Override
    public boolean add(String word) {
        return this.hashTable.add(word, PRESENT);
    }

    @Override
    public int size() {
        return this.hashTable.getSize();
    }

    @Override
    public boolean contains(String word) {
        return this.hashTable.containsKey(word);
    }

}
