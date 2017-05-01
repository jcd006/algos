package com.algos.sorting;

/**
 * Created by kiran on 4/26/2017.
 */
public class SelectionSort {

    public void sort(Comparable[] a) {
        for(int i=0; i<a.length; i++) {
            int min = i;
            for(int j=i+1; j<a.length; j++) {
                if(less(a[j], a[min])) {
                    min = j;
                }
            }
            swap(a, i, min);
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
        SelectionSort selectionSort = new SelectionSort();
        Integer[] a = new Integer[10];
        for(int i=0; i<a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        selectionSort.print(a);
        selectionSort.sort(a);
        selectionSort.print(a);
    }
}
