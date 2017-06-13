package com.algos.searching;

/**
 * Created by kiran on 6/6/2017.
 */
public class OrderedSymbolTable<Key extends Comparable<Key>, Value> {

    public void delete(Key key) {
        put(key, null);
    }

    public void put(Key key, Object o) {

    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return null;
    }

    public Key min() {
        return null;
    }

    public Key max() {
        return null;
    }

    public void deleteMin() {
        delete(min());
    }

    public void deleteMax() {
        delete(max());
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key min, Key max) {
        return null;
    }

    public int size(Key lo, Key hi) {
        if(hi.compareTo(lo) < 0) {
            return 0;
        } else if(contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo) + 1;
        }
    }

    public int rank(Key hi) {
        return 0;
    }
}
