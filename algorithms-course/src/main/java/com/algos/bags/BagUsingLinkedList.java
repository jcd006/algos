package com.algos.bags;

import java.util.Iterator;

/**
 * Created by kiran on 4/3/2017.
 *
 * Model a Bag using LinkedList as the backing collection
 *
 * Adding would be equivalent to adding an item at the beginning of the linked list
 *
 */
public class BagUsingLinkedList<T> implements Iterable<T> {

    Node first;

    int index;

    private class Node {

        T item;
        Node next;
    }
    /**
     * Insert item at the beginning of list
     *
     * This operation is independent of the size of the list!!!
     *
     * @param item
     */
    public void add(T item)  {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        index++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return index;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
