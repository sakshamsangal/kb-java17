package com.app.dsa.model.gfg.tree;

public class Node {
    public int data;
    public Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}