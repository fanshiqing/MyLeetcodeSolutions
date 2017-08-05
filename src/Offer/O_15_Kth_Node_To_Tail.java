package Offer;

/**
 * Created by sqfan on 8/4/17.
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 思路：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
 *      然后同时移动。
 */

public class O_15_Kth_Node_To_Tail {
  class ListNode {
    int val;
    ListNode next = null;
    ListNode(int v) { this.val = v; }
  }

  public ListNode FindKthToTail(ListNode head,int k) {
    if (k <= 0) return null;

    ListNode pre = head;
    ListNode suc = head;
    int i = 0;

    while (pre != null && ++i < k) pre = pre.next;
    if (pre == null) return null;
    while (pre.next != null) {
      pre = pre.next;
      suc = suc.next;
    }
    return suc;
  }

}
