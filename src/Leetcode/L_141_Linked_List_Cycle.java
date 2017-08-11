package Leetcode;

/**
 * Created by sqfan on 8/12/17.
 */
public class L_141_Linked_List_Cycle {
  public class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) { this.val = val; }
  }

  /**
   * 使用两个指针，一快一慢；若两者相遇，则表明存在环
   * 时间：O(n)
   * 空间：O(1)
   */
  public boolean hasCycle(ListNode head) {
    ListNode fast = head;
    ListNode slow = head;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }
}
