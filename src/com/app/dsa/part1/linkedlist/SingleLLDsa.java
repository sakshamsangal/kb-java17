package com.app.dsa.part1.linkedlist;

import com.app.dsa.model.ListNode;
import com.app.dsa.model.gfg.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleLLDsa {
    ListNode head;
    Node headGfg;

    public ListNode reverse(ListNode head, int k, int length) {
        if (length < k || head == null) {
            return head;
        }
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;

            curr.next = prev;
            prev = curr;

            curr = next;
            count++;
        }
        head.next = reverse(next, k, length - k);
        return prev;
    }

    void append(int k) {
        if (head == null) { // if list is empty
            head = new ListNode(k);
            return;
        }
        // if list is not empty
        // get hold of last node.
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // insert the node
        temp.next = new ListNode(k);
    }

    void addAtGivenIndex(int k, int index) {
        ListNode temp;
        if (head == null || index == 1) {
            temp = head;
            head = new ListNode(k);
            head.next = temp;
            return;
        }
        int count = 1;
        temp = head;
        while (count != index && temp.next != null) {
            count++;
            temp = temp.next;
        }
        ListNode x = temp.next;
        temp.next = new ListNode(k);
        temp.next.next = x;
    }

    void traverse() {
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

        System.out.println();
    }


    // For this, we hold the previous node to be deleted and
    // will connect to node which is after the deleted node.
    void deleteNodeAtGivenIndex(int index, int size) {
        // if list does not exist or size < index
        if (size < index || head == null) return;
        // if we want to delete at start
        if (index == 1) {
            head = head.next;
            return;
        }
        // if more than 1 node is there
        ListNode temp = head;
        for (int i = 0; i < index - 2; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    private ListNode reverseRec(ListNode head) {

        if (head.next == null) {
            return head;
        }
        ListNode newHead = reverseRec(head.next);
        ListNode tail = head.next;
        tail.next = head;
        head.next = null;

        return newHead;

    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static Node addToHead(Node head, Node item) {
        if (Objects.isNull(head)) {
            return item;
        }
        item.next = head;
        head = item;
        return head;
    }


    public int getLength(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        return count;
    }


    public void addLast(int k) {
        if (headGfg == null) { // if list is empty
            headGfg = new Node(k);
            return;
        }

        // if list is not empty
        // get hold of last node.
        Node curr = headGfg;
        while (curr.next != null) {
            curr = curr.next;
        }
        // insert the node
        curr.next = new Node(k);
    }


    public List<Integer> traverse(Node head) {
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        return list;
    }

    public static void main(String[] args) {
        SingleLLDsa listDsa = new SingleLLDsa();

        listDsa.addLast(20);
        listDsa.addLast(30);
        listDsa.addLast(40);

        List<Integer> traverse = listDsa.traverse(listDsa.headGfg);
        System.out.println("traverse = " + traverse);

    }
}