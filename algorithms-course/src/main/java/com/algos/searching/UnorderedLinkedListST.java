package com.algos.searching;

import java.util.Iterator;

/**
 * Created by kiran on 6/7/2017.
 */
public class UnorderedLinkedListST<Key, Value> extends SymbolTable<Key, Value> implements Iterable<Key>{

    private Node first;

    private int size;

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            size++;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    @Override
    public void eagerDelete(Key key) {

    }

    @Override
    public void put(Key key, Value value) {
        for(Node node = first; node.next!=null; node = node.next ) {
            if(key.equals(node.key)) {
                node.value = value;
            } else {
                first = new Node(key, value, first);
            }
        }
    }

    @Override
    public Value get(Key key) {
        for(Node node = first; node.next != null; node = node.next) {
            if(key.equals(node.key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
