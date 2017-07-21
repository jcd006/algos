package com.algos.searching;

/**
 * Created by kiran on 7/20/2017.
 */
public class SeparateChainingHashTable<Key, Value> {

    private int N;  //# of key, value pairs
    private int M;  //Size of hash table

    private UnorderedLinkedListST<Key, Value> [] sts;

    private int hash(Key key) {
        int hash = (key.hashCode() & 0x7fffffff) % M;
        return hash;
    }

    public SeparateChainingHashTable() {
        this(5);
    }

    public SeparateChainingHashTable(int M) {
        this.M = M;
        sts = new UnorderedLinkedListST[M];
        for(int i=0; i<M; i++) {
            sts[i] = new UnorderedLinkedListST<Key, Value>();
        }
    }

    public Value get(Key key) {
        return sts[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        sts[hash(key)].put(key, value);
    }

    public static void main(String[] args) {
        SeparateChainingHashTable<String, Integer> hashTable = new SeparateChainingHashTable<>();
        hashTable.put("S", 1);
        hashTable.put("E", 1);
        hashTable.put("A", 1);
        hashTable.put("R", 1);
        hashTable.put("C", 1);
        hashTable.put("H", 1);
        hashTable.put("E", 1);
        hashTable.put("X", 1);
        hashTable.put("A", 1);
        hashTable.put("M", 1);
        hashTable.put("P", 1);
        hashTable.put("L", 1);
        hashTable.put("E", 1);
    }
}
