package com.app.dsa.model;

public class NodeRandom {
    public int val;
    public NodeRandom next;
    public NodeRandom random;

    public NodeRandom(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}