package com.algos.stack;

import java.util.Iterator;

/**
 * Created by kiran on 4/3/2017.
 *
 * Model a stack using LinkedList as the backing collection
 *
 * Push would be equivalent to adding an item at the beginning of the linked list
 *
 * Pop would be equivalent to removing an itme from the beginning of the linked list
 *
 *
 */
public class StackUsingLinkedList<T> implements Iterable<T> {

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
    public void push(T item)  {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        index++;
    }

    /**
     * Remove item from the beginning of list
     *
     * This operation is independent of the size of the list!!!
     * @return
     */
    public T pop() {
        T item = first.item;
        first = first.next;
        index--;
        return item;
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
