import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class MyNode {
    int key;
    int value;
    MyNode next;
    MyNode prev;

    public MyNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


class LRUCache {
    Map<Integer, MyNode> map;
    int capacity;
    int count;
    MyNode head;
    MyNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new MyNode(0, 0);
        tail = new MyNode(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(MyNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(MyNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        MyNode node = map.get(key);
        int val = node.value;
        deleteNode(node);
        addToHead(node);
        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            MyNode node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        } else {
            MyNode node = new MyNode(key, value);
            map.put(key, node);
            if (count < capacity) {
                count++;
                addToHead(node);
            } else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
                addToHead(node);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end

