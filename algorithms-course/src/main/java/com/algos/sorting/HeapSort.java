package com.algos.sorting;

/**
 * Created by kiran on 5/17/2017.
 */
public class HeapSort {

    public void sort(Comparable[] a) {
        int length = a.length-1;
        //Heap construction
        for(int k = length/2; k > 0; k--) {
            sink(a, k, length);
        }
        //Sortdown
        while(length > 1) {
            swap(a, 1, length--);
            sink(a, 1, length);
        }
    }

    private void sink(Comparable[] a,  int index, int length) {
        while( 2 * index <= length) {
            int j = 2 * index;
            if(j < length && less(a, j, j+1)) {
                j++;
            }
            if(!less(a, index, j)) {
                break;
            }
            swap(a, index, j);
            index=j;
        }
    }

    private boolean less(Comparable [] pq, int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(Comparable [] pq, int i, int j) {
        Comparable a = pq[i];
        pq[i] = pq[j];
        pq[j] = a;
    }

    public static void main(String[] args) {
        String input = "SORTEXAMPLE";
        Character [] a = new Character[input.length() + 1];
        for(int i = 1; i<=input.length(); i++) {
            a[i] = input.charAt(i-1);
        }
        HeapSort heap = new HeapSort();
        for(Character c: a) {
            System.out.print(c);
        }
        System.out.println();
        heap.sort(a);
        for(Character c: a) {
            System.out.print(c);
        }
    }
}
