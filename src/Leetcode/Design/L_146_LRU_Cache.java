package Leetcode.Design;

import java.util.HashMap;

/**
 * 设计LRU Cache系统。
 * 思路： HashMap + 双向链表
 * We use two data structures to implement an LRU Cache.
 *   1. Queue which is implemented using a doubly linked list. The maximum size of the queue will
 * be equal to the total number of frames available (cache size).The most recently used pages
 * will be near front end and least recently pages will be near rear end.
 *   2. A Hash with page number as key and address of the corresponding queue node as value.
 *
 * When a page is referenced, the required page may be in the memory. If it is in the memory,
 * we need to detach the node of the list and bring it to the front of the queue.
 * If the required page is not in the memory, we bring that in memory. In simple words, we add
 * a new node to the front of the queue and update the corresponding node address in the hash.
 * If the queue is full, i.e. all the frames are full, we remove a node from the rear of queue,
 * and add the new node to the front of queue.
 */

public class L_146_LRU_Cache {
  /**
   * 双向链表类
   */
  class DLinkedNode {
    int key;
    int value;
    DLinkedNode prev;
    DLinkedNode next;
    DLinkedNode() {}
    DLinkedNode(int k, int v) {key = k; value = v;}
  }

  private HashMap<Integer, DLinkedNode> cache = new HashMap<>();
  private int capacity;
  private int count;
  private DLinkedNode head, tail; // Dummy head & tail for more concise code

  public L_146_LRU_Cache(int capacity) {
    this.capacity = capacity;
    this.count = 0;

    head = new DLinkedNode();
    tail = new DLinkedNode();
    head.prev = null;
    head.next = tail;
    tail.prev = head;
    tail.next = null;
  }

  // 时间：O(1)
  public int get(int key) {
    if (!cache.containsKey(key)) {
      return -1;
    }
    DLinkedNode node = cache.get(key);
    this.moveToHead(node); // 将最新访问的节点移动到循环队列头部

    return node.value;
  }

  // 时间：O(1)
  public void put(int key, int value) {
    if (cache.containsKey(key)) { // update value
      cache.get(key).value = value;
      moveToHead(cache.get(key));
      return ;
    }
    DLinkedNode node = new DLinkedNode(key, value);
    addNode(node);
    cache.put(key, node);

  }

  /**
   * 将节点node移动到双向链表的头部
   */
  private void moveToHead(DLinkedNode node) {
    removeNode(node);
    addNode(node);
  }

  /**
   * 在双向链表中插入新的节点。每次都是在head节点右侧插入
   */
  private void addNode(DLinkedNode node) {
    node.next = head.next;
    node.next.prev = node;
    node.prev = head;
    head.next = node;
    this.count ++;
    if (this.count > this.capacity) {
      removeTail();
    }
  }

  /**
   * 在双向链表中删除节点node。
   */
  private void removeNode(DLinkedNode node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
    node.prev = null;
    node.next = null;
    this.count --;
  }

  /**
   * 删除最近最少使用的尾巴节点
   */
  private void removeTail() {
    DLinkedNode delNode = tail.prev;
    removeNode(delNode);
    cache.remove(delNode.key); // 在map删除key
  }
  /**
   * Your LRUCache object will be instantiated and called as such:
   * LRUCache obj = new LRUCache(capacity);
   * int param_1 = obj.get(key);
   * obj.put(key,value);
   */
  public static void main(String[] args) {
    L_146_LRU_Cache cache = new L_146_LRU_Cache(2);
    cache.put(1, 1);
    cache.put(2, 2);
    System.out.println(cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    System.out.println(cache.get(2));       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    System.out.println(cache.get(1));       // returns -1 (not found)
    System.out.println(cache.get(3));       // returns 3
    System.out.println(cache.get(4));       // returns 4
  }

}


