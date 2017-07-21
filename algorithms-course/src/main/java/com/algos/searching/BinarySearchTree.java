package com.algos.searching;

import com.algos.queue.QueueUsingLinkedList;

/**
 * Created by kiran on 6/14/2017.
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N) {
            this.key = key;
            this.value = value;
            this.N = N;
        }
    }

    public Value get(Key key) {
     return get(root, key);
    }

    private Value get(Node node, Key key) {
        if(node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.value;
        }
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node put(Node node, Key key, Value value) {
        if(node == null) {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value;
        }
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public Key min() {
        return  min(root).key;
    }

    private Node min(Node node) {
        //return the left most node
        if(node.left == null)
            return node;
        return min(node.left);
    }

    public Key floor(Key key) {
        Node node = floor(root, key);
        if(node == null)
            return null;
        return node.key;
    }

    private Node floor(Node node, Key key) {
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0)
            return node;
        //floor is in the left sub-tree
        if(cmp < 0)
            return floor(node.left, key);
        //floor could be in the right sub-tree
        //could be because there needs to be a key
        //in the right subtree lower than or equal
        //to the key
        Node t = floor(node.right, key);
        if(t != null)
            return t;
        else
            return node;
    }

    public Key ceiling(Key key) {
        Node node = ceiling(root, key);
        if(node == null)
            return null;
        return node.key;
    }

    private Node ceiling(Node node, Key key) {
        if(node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0)
            return node;
        if(cmp > 0)
            return ceiling(node.right, key);
        Node t = ceiling(node.left, key);
        if(t != null)
            return t;
        else
            return node;
    }

    public Key max() {
        return max(root).key;
    }

    private Node max(Node node) {
        //return the right most node
        if(node.right == null)
            return node;
        return max(node.right);
    }

    private int size(Node node) {
        if(node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    public Node select(int rank) {
        return select(root, rank);
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node node, Key key) {
        if(node == null)
            return 0;
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            return rank(node.left, key);
        else if(cmp > 0)
            return 1 + size(node.left) + rank(node.right, key);
        else
            return size(node.left);
    }

    private Node select(Node node, int rank) {
        if(node == null)
            return null;
        int t = size(node.left);
        if(t > rank)
            return select(node.left, rank);
        if(t < rank)
            return select(node.right, rank-t-1);
        else
            return node;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node node) {
       if(node.left == null)
           return node.right;
        node.left = deleteMin(node.left);
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void deleteMax() {
        root = deleteMax(root);
    }

    private Node deleteMax(Node node) {
        if(node.right == null)
            return node.left;
        node.right = deleteMax(node.right);
        node.N = 1 + size(node.left) + size(node.right);
        return node;
    }

    public void delete(Key key) {
        root = delete(root, key);
    }

    /**
     * In order traversal of BST
     *
     * @param node
     */
    public void print(Node node) {
        if(node == null)
            return;
        print(node.left);
        System.out.print(node.key);
        print(node.right);
    }

    public void print() {
        print(root);
    }

    private Node delete(Node x, Key key) {
        if(x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp < 0)
            x.left = delete(x.left, key);
        else if(cmp > 0)
            x.right = delete(x.right, key);
        else {
            Node t = x;
            x = min(x.right);
            x.left = t.left;
            x.right = deleteMin(t.right);
        }
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        QueueUsingLinkedList<Key> queue = new QueueUsingLinkedList<Key>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node node, QueueUsingLinkedList<Key> queue, Key lo, Key hi) {
        if(node == null)
            return;
        int cmpLo = lo.compareTo(node.key);
        int cmpHi = hi.compareTo(node.key);
        if(cmpLo < 0)
            keys(node.left, queue, lo, hi);
        if(cmpLo <= 0 && cmpHi >= 0)
            queue.enqueue(node.key);
        if(cmpHi > 0)
            keys(node.right, queue, lo, hi);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public static void main(String[] args) {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
        bst.put("S", 1);
        bst.put("E", 5);
        bst.put("X", 3);
        bst.put("A", 3);
        bst.put("C", 2);
        bst.put("R", 2);
        bst.put("H", 4);
        bst.put("M", 9);
        bst.put("X", 2);
//        System.out.println(bst.min().key);
//        System.out.println(bst.max().key);
//        System.out.println(bst.floor("S"));
//        System.out.println(bst.ceiling("G"));
//        System.out.println(bst.select(3));
//        System.out.println(bst.rank("G"));
//        bst.deleteMin();
//        System.out.println(bst.min().key);
//        bst.deleteMin();
//        System.out.println(bst.min().key);
//        System.out.println(bst.max().key);
//        bst.deleteMax();
//        System.out.println(bst.max().key);
//        bst.delete("E");
//        System.out.println();
//        System.out.println(bst.max().key);
//        bst.print();
        System.out.println(bst.keys("C", "R"));
    }
}
