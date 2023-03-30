package com.example.arithmetic.linkedlist.lru;

import java.util.HashMap;

/**
 * @author：zhongyao
 * @date：2023/3/30
 * @description：手动实现LRU缓存： 哈希 + 双向链表实现
 */
public class LRUCache {

    HashMap<Integer, Node> map;
    DoubleLinkedList cache;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        cache = new DoubleLinkedList();
        this.capacity = capacity;
    }

    public void put(int key, int val) {
        Node newNode = new Node(key, val);
        if (map.containsKey(key)) {
            cache.delete(map.get(key));
        } else {
            if (map.size() == capacity) {
                int k = cache.deleteLast();
                map.remove(k);
            }
        }
        cache.addFirst(newNode);
        map.put(key, newNode);
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        int value = map.get(key).val;
        put(key, value);
        return value;
    }
}

class DoubleLinkedList {
    Node head;
    Node tail;

    public DoubleLinkedList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int delete(Node node) {
        int key = node.key;
        node.next.prev = node.prev;
        node.prev.next = node.next;
        return key;
    }

    public int deleteLast() {
        if (head.next == tail) return -1;
        return delete(tail.prev);
    }
}


class Node{
    public int key;
    public int val;
    public Node prev;
    public Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}