package com.algos.priorityqueues;

/**
 * Created by kiran on 5/17/2017.
 *
 * Both delMax() and insert() operations are guaranteed to complete in log N
 *
 * pq[0] is unused and heap exists from pq[1] through pq[N]
 */
public class MaxPQUsingHeapOrderedCompleteBinaryTree<T extends Comparable<T>> {

    private T [] pq;

    private int N = 0;

    public MaxPQUsingHeapOrderedCompleteBinaryTree(int maxN) {
        pq = (T[]) new Comparable[maxN];
    }

    public void insert(T key) {
        pq[++N] = key;
        swim(N);
    }

    public T delMax() {
        T max = pq[1];
        swap(1, N--);
        pq[N+1] = null;
        sink(1);
        return max;
    }

    private void swim(int index) {
        while(index > 1 && less(index/2, index)) {
            swap(index/2, index);
            index = index/2;
        }
    }

    private void sink(int index) {
        while( 2 * index <= N) {
            int j = 2 * index;
            if(j < N && less(j, j+1)) {
                j++;
            }
            if(!less(index, j)) {
                break;
            }
            swap(index, j);
            index=j;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void swap(int i, int j) {
        T a = pq[i];
        pq[i] = pq[j];
        pq[j] = a;
    }

    public static void main(String[] args) {
        MaxPQUsingHeapOrderedCompleteBinaryTree<Integer> heap = new MaxPQUsingHeapOrderedCompleteBinaryTree<>(5);
        heap.insert(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(10);
        System.out.println(heap.delMax());
        System.out.println(heap.delMax());
    }
}
