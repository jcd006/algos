package com.algos.sorting;

/**
 * Created by kiran on 4/26/2017.
 */
public class ShellSort {

    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while(h < N/3) {
            h = 3*h + 1;
        }
        while(h >= 1) {
            for(int i=h; i<N; i++) {
                for( int j=i; j >=h && less(a[j], a[j-h]); j-=h) {
                    swap(a, j, j-h);
                }
            }
            h/=3;
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
        ShellSort selectionSort = new ShellSort();
        Integer[] a = new Integer[15];
        for(int i=0; i<a.length; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        selectionSort.print(a);
        selectionSort.sort(a);
        selectionSort.print(a);
    }
}
