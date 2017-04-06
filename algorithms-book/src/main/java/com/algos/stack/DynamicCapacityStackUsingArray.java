package com.algos.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by kiran on 3/27/2017.
 */
public class DynamicCapacityStackUsingArray<T> implements Iterable<T> {

    int index;

    T [] dataStore;

    public DynamicCapacityStackUsingArray() {
        dataStore = (T[]) new Object [1];
    }

    public void push(T number) {
        if(index == dataStore.length) {
            resize(2 * dataStore.length);
        }
        dataStore[index++] = number;
    }

    private void resize(int newCapacity) {
        T [] dataStoreNew = (T[]) new Object[newCapacity];
        System.arraycopy(dataStore, 0, dataStoreNew, 0, dataStore.length);
        dataStore = dataStoreNew;
    }

    public T pop() {
        T item = dataStore[--index];
        if(index == index/4) {
            resize(index/2);
        }
        dataStore[index] = null;
        return item;
    }

    public int size() {
        return index;
    }

    public Iterator<T> iterator() {
        return new ReverseOrderIterator<T>();
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public static void main(String[] args) {
       DynamicCapacityStackUsingArray<String> stack = new DynamicCapacityStackUsingArray<String>();
        stack.push("1");
        stack.push("3");
        stack.push("4");
        stack.push("2");
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
    }

    private class ReverseOrderIterator<T> implements Iterator<T> {

        private int i = index;

        public boolean hasNext() {
            return i > 0;
        }

        public T next() {
            if(i==0) {
                throw new NoSuchElementException();
            }
            return (T) dataStore[--i];
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
