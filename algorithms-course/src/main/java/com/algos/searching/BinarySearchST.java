package com.algos.searching;

import com.algos.queue.QueueUsingLinkedList;

import java.util.Iterator;

/**
 * Created by kiran on 6/12/2017.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

    private Key [] keys;
    private Value [] vals;
    private int N;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
        N=0;
    }

    public void put(Key key, Value value) {
        int i = rank(key);

        //Match found for key, replace value
        if( i < N && keys[i].compareTo(key) == 0 ) {
            vals[i] = value;
            return;
        }
        //Match not found, insert key, value
        //into position i by shifting keys, values one
        //position to the right
        for(int j=N; j>i; j--) {
            keys[j] = keys[j-1];
            vals[j] = vals[j-1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Value get(Key key) {
        if(isEmpty()) {
            return null;
        }
        int i = rank(key);
        if( i < N && keys[i].compareTo(key) == 0 ) {
            return vals[i];
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private int rank(Key key) {
        int lo=0;
        int hi=N-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(key.compareTo(keys[mid]) > 0) {
                lo = mid + 1;
            } else if(key.compareTo(keys[mid]) < 0) {
                hi = mid-1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public boolean isEmpty() {
        return N==0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N-1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        return keys[rank(key)];
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        QueueUsingLinkedList<Key> queue = new QueueUsingLinkedList();
        for(int i=rank(lo); i<rank(hi); i++) {
            queue.enqueue(keys[i]);
            System.out.println(keys[i]);
        }
        if(contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    //TODO
    public void delete(Key key) {

    }

    public static void main(String[] args) {
        BinarySearchST<Integer, String> bst = new BinarySearchST<>(10);
        bst.put(1, "a");
        bst.put(3, "c");
        bst.put(5, "e");
        bst.put(2, "b");
        bst.put(4, "d");

        Iterator<Integer> iterator = bst.keys(1, 3).iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
