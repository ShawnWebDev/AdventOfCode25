package com.webdev.util;

public class Node {
    Node next;
    Node prev;
    int data;
    public Node(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrev() {
        return prev;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public int getData() {
        return data;
    }
}