package com.algos.utils;

import com.algos.problems.StopWatch;
import com.algos.problems.ThreeSumFast;

/**
 * Created by kiran on 4/17/2017.
 */
public class DoublingRatio {
    public static double timeTrial(int N) {
        // Time ThreeSum.count() for N random 6-digit ints.
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = (int) (Math.random() * 10);
        }
        StopWatch timer = new StopWatch();
        int cnt = ThreeSumFast.count(a);
        return timer.elapsedTime();
    }
    public static void main(String[] args) { // Print table of running times.
        double prev = timeTrial(125);
        for (int N = 250; true; N += N)
        {
            double time = timeTrial(N);
            System.out.printf("%6d %7.1f ", N, time);
            System.out.printf("%5.1f\n", time/prev);
            prev = time;
        }
    }
}
