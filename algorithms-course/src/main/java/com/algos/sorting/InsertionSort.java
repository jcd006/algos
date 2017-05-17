package com.algos.sorting;

/**
 * Created by kiran on 4/26/2017.
 */
public class InsertionSort {

    public void sort(Comparable[] a) {
        for(int i=1; i<a.length; i++) {
            for(int j=i; j>0 && less(a[j], a[j-1]); j--) {
                swap(a, j, j-1);
            }
        }
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

    public void print(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        Integer[] a = new Integer[10];
        for(int i=0; i<a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        insertionSort.print(a);
        insertionSort.sort(a);
        insertionSort.print(a);
    }
}
