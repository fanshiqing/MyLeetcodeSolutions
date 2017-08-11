package Leetcode;

/**
 * Created by sqfan on 8/12/17.
 */
public class L_142_Linked_List_Cycle_II {
  public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) { this.val = val; }
  }

  /**
   * 双指针。
   * 时间：O(n)
   */
  public ListNode detectCycle(ListNode head) {
    if (head == null || head.next == null) return null;
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) break;
    }
    if (fast != slow) return null;
    ListNode p = head;
    while (p != slow) {
      p = p.next;
      slow = slow.next;
    }
    return p;
  }
}
