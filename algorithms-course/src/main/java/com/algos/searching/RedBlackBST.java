package com.algos.searching;

/**
 * Created by kiran on 7/5/2017.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private boolean color;
        private Node left, right;
        private int N;

        public Node(Key key, Value value, int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;
        }
    }

    private boolean isRed(Node node) {
        if(node == null)
            return false;
        return node.color == RED;
    }

    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        x.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return x;
    }

    private int size(Node node) {
        if(node == null) {
            return 0;
        } else {
            return node.N;
        }
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        x.N = node.N;
        node.N = 1 + size(node.left) + size(node.right);
        return x;
    }

    private void flipColors(Node node) {
        node.left.color = BLACK;
        node.right.color = BLACK;
        node.color = RED;
    }

    public Node insert(Key key, Value value) {
        root = insert(root, key, value);
        root.color = BLACK;
        return root;
    }

    private Node insert(Node node, Key key, Value value) {
        if(node == null)
            return new Node(key, value, 1, RED);
        int cmp = key.compareTo(node.key);
        if(cmp < 0)
            node.left = insert(node.left, key, value);
        else if(cmp > 0)
            node.right = insert(node.right, key, value);
        else
            node.value = value;
        if(isRed(node.right) && !isRed(node.left))
            node = rotateLeft(node);
        else if(isRed(node.left) && isRed(node.left.left))
            node = rotateRight(node);
        else if(isRed(node.left) && isRed(node.right))
            flipColors(node);
        return node;
    }

    public static void main(String[] args) {
        RedBlackBST<String, Integer> redBlackBST = new RedBlackBST<>();
        redBlackBST.insert("S", 1);
        redBlackBST.insert("E", 3);
        redBlackBST.insert("A", 4);
        redBlackBST.insert("R", 5);
        redBlackBST.insert("C", 7);
        redBlackBST.insert("H", 3);
        redBlackBST.insert("X", 5);
        redBlackBST.insert("M", 7);
        redBlackBST.insert("P", 0);
        redBlackBST.insert("L", 9);
    }
}
