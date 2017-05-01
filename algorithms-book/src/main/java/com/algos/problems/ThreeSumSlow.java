package com.algos.problems;

import com.algos.utils.StopWatch;

/**
 * Created by kiran on 4/10/2017.
 */
public class ThreeSumSlow {

    private static int target = 3;

    public static void main(String[] args) {
        int [] a = new int [2000];

        int count = 0;

        for(int i=0; i<a.length; i++) {
            a[i] = (int) (3 * Math.random());
        }

        StopWatch stopWatch = new StopWatch();

        for(int i=0; i<a.length; i++) {
            for(int k=i+1; k<a.length; k++) {
                for(int j=k+1; j<a.length; j++) {
                    int first = a[i];
                    int second  = a[k];
                    int third = a[j];
                    if(first + second + third == target) {
                        count++;
                    }
                }
            }
        }

        System.out.println("Elapsed time = " + stopWatch.elapsedTime());

        System.out.println(count);


    }
}
