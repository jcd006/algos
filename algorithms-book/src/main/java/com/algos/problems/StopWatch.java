package com.algos.problems;

/**
 * Created by kiran on 4/10/2017.
 */
public class StopWatch {

    private final long start;


    public StopWatch() {
        start = System.nanoTime();
    }

    public double elapsedTime() {
        long now = System.nanoTime();
        return (now-start)/1000000.0;
    }
}
