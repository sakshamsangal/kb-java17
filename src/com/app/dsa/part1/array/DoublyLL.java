package com.app.dsa.part1.array;

public class DoublyLL {
    static class Node {
        Node prev;
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head;
    Node tail;

    public DoublyLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addFirst(Node node) {
        node.next = head;
        head.prev = node;
        head = node;
    }

    void removeNode(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        node.next.prev = prev;
    }

    void moveToHead(Node node) {
        removeNode(node);
        addFirst(node);
    }
}
