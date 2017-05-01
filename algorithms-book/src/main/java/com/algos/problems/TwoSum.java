package com.algos.problems;

import java.util.Arrays;

/**
 * Created by kiran on 4/12/2017.
 */
public class TwoSum {

    public static void printTwoSumIndexes(int [] a, int target) {
        //Merge sort -- NlogN
        Arrays.sort(a);
        for(int i=0; i<a.length; i++) {
            int index = BinarySearch.rank(target-a[i], a);
            if( index > i) {
                System.out.println("Two sum indexes = " + i + ", " + index);
            }
        }
    }

    public static void main(String[] args) {
        int [] a = {0, 1, 2, 2, 3, 1};
        int [] b = {0, 1, 1, 2, 2, 3};
        printTwoSumIndexes(a, 3);
    }
}
