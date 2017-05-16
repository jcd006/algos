package com.algos.problems;

import com.algos.utils.StopWatch;

import java.util.Arrays;

/**
 * Created by kiran on 4/17/2017.
 */
public class ThreeSumFast {

    public static int count(int [] a) {
        int count = 0;

        Arrays.sort(a);

        StopWatch stopWatch = new StopWatch();

        for(int i=0; i<a.length; i++) {
            for(int k=i+1; k<a.length; k++) {
                if(BinarySearch.rank(-a[i]-a[k], a) > k) {
                    count++;
                }
            }
        }
        return count;
    }
}
