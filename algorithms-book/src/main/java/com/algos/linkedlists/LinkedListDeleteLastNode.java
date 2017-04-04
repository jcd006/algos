package com.algos.linkedlists;

/**
 * Created by kiran on 4/2/2017.
 */
public class LinkedListDeleteLastNode {

    public static void main(String[] args) {
        LinkedListDeleteLastNode program = new LinkedListDeleteLastNode();
        program.deleteLastNode();
    }

    private void deleteLastNode() {
        Node<String> first = new Node<String>();
        Node<String> second = new Node<String>();
        Node<String> third = new Node<String>();
        Node<String> fourth = new Node<String>();
        Node<String> fifth = new Node<String>();
        first.value = "first";
        second.value = "second";
        third.value = "third";
        fourth.value = "fourth";
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        //Traverse to find the last element and remove it
        for(Node node = first; node != null; node = node.next) {
            if(node.next != null && node.next.next == null) {
                node.next = null;
                System.out.println("Second from last Node == " + node.value);
            }
            System.out.println(node.value);
        }

        //Print new list after last node is removed
        for(Node node = first; node != null; node = node.next) {
            System.out.println(node.value);
        }
    }

    private class Node<T> {
        T value;
        Node next;
    }
}
