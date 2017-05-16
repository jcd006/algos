package com.algos.sorting;

/**
 * Created by kiran on 4/26/2017.
 */
public class QuickSort {

    public void sort(Comparable[] a) {
        //TODO Random shuffle to remove dependence on input
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //exit condition
        if(hi <= lo) return;
        int j = partition(a, lo, hi);
        //sort a[lo...partition-1]
        sort(a, lo, j-1);
        //sort [partition+1...hi]
        sort(a, j+1, hi);
    }

    /**
     * 1. Partition on arbitrarily chosen a[lo]
     * 2. Scan indices from left until item is greater than a[lo]
     * 3. Scan indices from right until item is less than a[lo]
     * 4. Exchange and continue until both left and right indices meet
     *
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        Comparable v = a[lo];
        while(true) {
            while(less(a[++i], v)) {
                if(i == hi) {
                    break;
                }
            }
            while(less(v, a[--j])) {
                if(j == lo) {
                    break;
                }
            }
            if(i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);
        return j;
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
        QuickSort quickSort = new QuickSort();
        Character [] a = "KRATELEPUIMQCXOS".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        quickSort.print(a);
        quickSort.sort(a);
        quickSort.print(a);
    }
}
