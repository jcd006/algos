package com.algos.priorityqueues;

/**
 * Created by kiran on 5/15/2017.
 */
public class MaxPQUsingArray {

    private Integer [] keys;

    int index;

    MaxPQUsingArray(int initialSize) {
        keys =  new Integer[initialSize];
    }

    public void insert(Integer key) {
        keys[index++] = key;
    }

    public Comparable delMax() {
        int max=0;
        for(int j=1; j<index; j++) {
            if(less(keys[max], keys[j])) {
                max = j;
            }
        }
        swap(keys, max, index-1);
        Comparable maxElement = keys[--index];
        keys[index] = null;
        return maxElement;
    }

    private boolean less(Comparable v, Comparable w) {
        if(v.compareTo(w) < 0) {
            return true;
        }
        return false;
    }

    private static void swap(Comparable[] v, int i, int j) {
        Comparable a = v[i];
        v[i] = v[j];
        v[j] = a;
    }

    public static void main(String [] args) {
        MaxPQUsingArray maxPQ = new MaxPQUsingArray(10);
        maxPQ.insert(3);
        maxPQ.insert(1);
        maxPQ.insert(7);
        maxPQ.insert(11);
        maxPQ.insert(5);
        System.out.println(maxPQ.delMax());
        maxPQ.insert(8);
        System.out.println(maxPQ.delMax());
        System.out.println(maxPQ);
    }
}
