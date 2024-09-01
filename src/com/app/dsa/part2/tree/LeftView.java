package com.app.dsa.part2.tree;

import com.app.dsa.model.gfg.tree.Node;

import java.util.*;

public class LeftView {

    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> nodes = new ArrayList<>();
        levelOrderTra(root, nodes);
        return nodes;
    }

    private void levelOrderTra(Node root, ArrayList<Integer> nodes) {
        Queue<Node> readyToPrint = new LinkedList<>();
        readyToPrint.add(root);

        while (!readyToPrint.isEmpty()) {
            int size = readyToPrint.size();
            nodes.add(readyToPrint.peek().data);
            for (int i = 0; i < size; i++) {
                Node poll = readyToPrint.poll();

                if (Objects.nonNull(poll.left)) {
                    readyToPrint.add(poll.left);
                }
                if (Objects.nonNull(poll.right)) {
                    readyToPrint.add(poll.right);
                }

            }
        }

    }
}
