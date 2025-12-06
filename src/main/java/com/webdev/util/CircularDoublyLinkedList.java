package com.webdev.util;

public class CircularDoublyLinkedList {
    private final Node head;
    private final int size;

    public CircularDoublyLinkedList(Node head, int size) {
        this.head = head;
        this.size = size;
    }

    public void populateList() {
        Node current = this.head;
        Node next;
        for (int i = 1; i < this.size; i++) {
            next = new Node(i);
            current.setNext(next);
            next.setPrev(current);
            current = current.getNext();
        }
        current.setNext(this.head);
        this.head.setPrev(current);
    }

    public Node getStartingNode(int startingNode) {
        Node current = this.head;
        for (int i = 0; i < startingNode; i++) {
            current = current.getNext();
        }
        return current;
    }
}
