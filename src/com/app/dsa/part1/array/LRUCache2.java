package com.app.dsa.part1.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class LRUCache2 {
    int cap;
    Map<Integer, DoublyLL.Node> map = new HashMap<>();
    DoublyLL doublyLL = new DoublyLL();

    public LRUCache2(int capacity) {
        this.cap = capacity;
    }

    public int get(int key) {
        DoublyLL.Node node = map.get(key);
        if (Objects.isNull(node)) {
            return -1;
        }
        doublyLL.moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.size() == cap) {
            doublyLL.removeNode(doublyLL.tail.prev);
            map.remove(doublyLL.tail.prev.key);
        }
        DoublyLL.Node node = map.get(key);
        if (Objects.isNull(node)) {
            DoublyLL.Node newNode = new DoublyLL.Node(key, value);
            map.put(key, newNode);
            doublyLL.addFirst(newNode);
        } else {
            node.val = value;
            doublyLL.moveToHead(node);
        }
    }

    public static void main(String[] args) {
        LRUCache2 lRUCache = new LRUCache2(2);
        lRUCache.get(2);    // return 1
        lRUCache.put(2, 6); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(1);    // returns -1 (not found)

        lRUCache.put(1, 5); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.put(1, 2); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(2);    // return 3
    }
}
