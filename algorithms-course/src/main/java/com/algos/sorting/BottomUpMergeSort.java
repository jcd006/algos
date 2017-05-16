package com.algos.sorting;

/**
 * Created by kiran on 4/26/2017.
 */
public class BottomUpMergeSort {

    private Comparable[] aux;

    public void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        for(int sz=1; sz<N; sz += sz) {
            for(int lo=0; lo<N-sz; lo += sz+sz) {
                int mid = lo+sz-1;
                int high = Math.min(lo+sz+sz-1, N-1);
                merge(a, lo, mid, high);
            }
        }

    }

    public void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        int j= mid+1;

        //Copy input array into auxiliary array
        for(int k=lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        //Merge arrays a[lo..mid] and a[mid+1...hi]
        for(int k=lo; k <= hi; k++) {
            //Left half is merged
            if(i > mid) {
                a[k] = aux[j++];
            }
            //Right half is merged
            else if(j > hi) {
                a[k] = aux[i++];
            }
            //Key on the right is lower than left
            //Take from the right
            else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            }
            //Key on the left is equal or lower than right
            //Take from the left
            else {
                a[k] = aux[i++];
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
        BottomUpMergeSort selectionSort = new BottomUpMergeSort();
        Integer[] a = new Integer[15];
        for(int i=0; i<a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        selectionSort.print(a);
        selectionSort.sort(a);
        selectionSort.print(a);
    }
}
