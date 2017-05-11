package com.algos.sorting;

/**
 * Improves quick sort when a large
 * number of array elements are duplicate
 * to almost time proportional to linear.
 *
 * Created by kiran on 4/26/2017.
 */
public class QuickSortThreeWayPartition {

    public void sort(Comparable[] a) {
        //TODO Random shuffle to remove dependence on input
        sort(a, 0, a.length-1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        //exit condition
        if(hi <= lo) return;
        int lt=lo;
        int gt = hi;
        int i = lo+1;
        Comparable v = a[lo];
        while(i <= gt) {
            int cmp = a[i].compareTo(v);
            //Swap a[i] with a[lt] and increment lt, i
            //Elements less than v end up between
            //a[lo] and a[lt-1]
            if(cmp < 0) {
                swap(a, lt++, i++);
            }
            //Swap a[i] with a[gt] and decrement gt
            //Elements greater than v end up between
            // a[gt+1] and a[hi]
            else if(cmp > 0) {
                swap(a, i, gt--);
            }
            //Equal so increment i
            //Elements equal to v end up between
            //a[lt] and a[i-1]
            else{
                i++;
            }
        }
        //sort a[lo...partition-1]
        sort(a, lo, lt-1);
        //sort [partition+1...hi]
        sort(a, gt+1, hi);
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
        QuickSortThreeWayPartition quickSort = new QuickSortThreeWayPartition();
        Character [] a = "RBWWRWBRRWBR".chars().mapToObj(c -> (char)c).toArray(Character[]::new);
        quickSort.print(a);
        quickSort.sort(a);
        quickSort.print(a);
    }
}
