package com.app.dsa.part2.dp_1d;


import com.app.dsa.model.gfg.tree.Node;

import java.util.Objects;

public class Sample8_21_30 {
    void mirror(Node node) {
        if (Objects.isNull(node)) {
            return;
        }
        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

    }
}
