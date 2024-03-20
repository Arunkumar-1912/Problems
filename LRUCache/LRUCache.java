package org.example.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K,V> {

    private final Node<K, V> head;
    private final Node<K, V> tail;
    private final Map<K, Node<K, V>> map;
    private final int capacity;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<>();
    }

    public V get(K key){
        if (map.containsKey(key)){
            Node<K, V> curNode = map.get(key);
            remove(curNode);
            insert(curNode);
            return curNode.value;
        }
        return null;
    }

    public void put(K key , V value){
        Node<K, V> node = new Node<>(key, value);
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        if (map.size() == capacity){
            remove(tail.prev);
        }
        insert(node);
    }

    private void remove(Node<K, V> node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node<K, V> node){
        map.put(node.key, node);
        Node<K, V> headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }

    public String displayCache() {
        System.out.println("Cache Contents");
        StringBuilder builder = new StringBuilder();
        if (map.size() != 0){
            builder.append("{");
        }
        for (Map.Entry<K,Node<K,V>> entry : map.entrySet()){
            builder.append(entry.getKey());
            builder.append(":");
            builder.append(entry.getValue().value);
            builder.append(",");
        }
        builder.append("}");
        return builder.toString();
    }

    private static class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        Node(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
}
