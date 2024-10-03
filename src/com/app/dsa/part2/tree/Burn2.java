package com.app.dsa.part2.tree;


import com.app.dsa.model.gfg.tree.Node;

import java.util.*;

public class Burn2 {

    static Node srcNode;
    static Map<Node, Node> map = new HashMap<>();
    static Map<Node, Boolean> visited = new HashMap<>();

    public static void storeParent(Node root, Node parent, int src) {

        if (Objects.isNull(root)) {
            return;
        }
        storeParent(root.left, root, src);

        map.put(root, parent);
        if (root.data == src) {
            srcNode = root;
        }

        storeParent(root.right, root, src);
    }

    public static int minTime(Node root, int target) {
        storeParent(root, null, target);

        visited.put(srcNode, true);
        int level = 0;

        Queue<Node> readyForBurn = new LinkedList<>();
        readyForBurn.add(srcNode);

        while (!readyForBurn.isEmpty()) {

            int size = readyForBurn.size();
            level++;

            for (int i = 0; i < size; i++) {
                Node poll = readyForBurn.poll();

                if (Objects.nonNull(poll.left) && !visited.getOrDefault(poll.left, false)) {
                    visited.put(poll.left, true);
                    readyForBurn.add(poll.left);
                }

                if (Objects.nonNull(poll.right) && !visited.getOrDefault(poll.right, false)) {
                    visited.put(poll.right, true);
                    readyForBurn.add(poll.right);
                }

                Node par = map.get(poll);
                if (Objects.nonNull(par) && !visited.getOrDefault(par, false)) {
                    visited.put(par, true);
                    readyForBurn.add(par);
                }
            }

        }

        map.clear();
        visited.clear();
        return level;
    }

}