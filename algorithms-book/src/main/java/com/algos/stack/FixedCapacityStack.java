package com.algos.stack;

/**
 * Created by kiran on 3/22/2017.
 */
public class FixedCapacityStack<T> {

    int index;

    T [] dataStore;

    public FixedCapacityStack(int capacity) {
        dataStore = (T[]) new Object [capacity];
    }

    public void push(T number) {
        dataStore[index++] = number;
    }

    public T pop() {
        return dataStore[--index];
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public static void main(String[] args) {
        FixedCapacityStack<Integer> stack = new FixedCapacityStack<Integer>(10);
        stack.push(10);
        stack.push(9);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        stack.push(8);
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.size());
    }
}
