package com.algos.queue;

import java.util.Iterator;

/**
 * Created by kiran on 4/5/2017.
 */
public class QueueUsingLinkedList<T> implements Iterable<T> {

    Node first;
    Node last;

    int index;

    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.value;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class Node {
        T value;
        Node next;
    }

    /**
     * Add value to the end of the LinkedList
     *
     * This operation is independent of size of the list
     */
    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.value = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        index++;
    }

    /**
     * Remove and return first element from the linked list
     *
     * This operation is independent of the size of the list!
     *
     * @return
     */
    public T dequeue() {
        T item = null;
        if(first != null) {
            item = first.value;
            first = first.next;
        }
        if(isEmpty()) {
            last = null;
        }
        index--;
        return item;
    }

    public int size() {
        return index;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList<String> queue = new QueueUsingLinkedList<String>();
        queue.enqueue("1");
        queue.dequeue();
        queue.dequeue();
        //queue.enqueue("2");
        //queue.dequeue();
    }
}
