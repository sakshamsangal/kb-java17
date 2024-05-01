package com.app.dsa.part2.tree;

import com.app.dsa.model.HdPair;
import com.app.dsa.model.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class View {
    int levelSeen = 0;

    public void printLeft(Node root, int currLevel) {
        if (root == null)
            return;
        if (levelSeen < currLevel) {
            System.out.print(root.data + " ");
            levelSeen = currLevel;
        }
        printLeft(root.left, currLevel + 1);
        printLeft(root.right, currLevel + 1);
    }

    public void printLeftView(Node root) {
        printLeft(root, 1);
    }


    public void bottomView(Node root) {
        Queue<HdPair> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new HdPair(root, 0));
        while (!q.isEmpty()) {
            HdPair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            mp.put(hd, curr.data);
            if (curr.left != null)
                q.add(new HdPair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new HdPair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

    public  void topView(Node root) {
        Queue<HdPair> q = new LinkedList<>();
        Map<Integer, Integer> mp = new TreeMap<>();
        q.add(new HdPair(root, 0));
        while (!q.isEmpty()) {
            HdPair p = q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if (!mp.containsKey(hd))
                mp.put(hd, curr.data);
            if (curr.left != null)
                q.add(new HdPair(curr.left, hd - 1));
            if (curr.right != null)
                q.add(new HdPair(curr.right, hd + 1));
        }
        for (Map.Entry<Integer, Integer> x : mp.entrySet()) {
            System.out.print(x.getValue() + " ");
        }
    }

}
