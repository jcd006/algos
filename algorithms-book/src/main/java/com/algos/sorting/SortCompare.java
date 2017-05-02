package com.algos.sorting;

import com.algos.utils.StopWatch;

/**
 * Created by kiran on 4/30/2017.
 */
public class SortCompare {

    public static void main(String [] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        //Total # of random arrays
        int T = Integer.parseInt(args[2]);
        //Size of each random array
        int N = Integer.parseInt(args[3]);

        //measure the total time for each algorithm
        double t1 = time(alg1, T, N);
        double t2 = time(alg2, T, N);

        System.out.printf("Sort time for %s is %.2f\n", alg1, t1);
        System.out.printf("Sort time for %s is %.2f\n", alg2, t2);

        System.out.printf("For %d random doubles %s is ", N, alg1);
        System.out.printf("%.1f times faster than %s\n", t2/t1, alg2);


    }

    private static double time(String alg, int T, int N) {
        double totalTime = 0;
        for(int i=0; i<T; i++) {
            Double[] a = new Double[N];
            for(int j=0; j<N; j++) {
                a[j] = Math.random() * 10;
            }
            totalTime += time(alg, a);
        }
        return totalTime;
    }

    private static double time(String alg, Comparable[] a) {
        StopWatch watch = new StopWatch();
        if(alg.equalsIgnoreCase("Insertion")) {
            InsertionSort sort = new InsertionSort();
            sort.sort(a);
        } else if(alg.equalsIgnoreCase("Selection")) {
            SelectionSort sort = new SelectionSort();
            sort.sort(a);
        } else if(alg.equalsIgnoreCase("Shell")) {
            ShellSort sort = new ShellSort();
            sort.sort(a);
        }
        return watch.elapsedTime();
    }
}
