package com.algos.searching;

/**
 * Created by kiran on 6/6/2017.
 */
public abstract class SymbolTable<Key, Value> {

    public void lazyDelete(Key key) {
        put(key, null);
    }

    public abstract void eagerDelete(Key key);

    public abstract void put(Key key, Value o);

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public abstract Value get(Key key);

    public abstract Iterable<Key> keys();

    public abstract int size();
}
