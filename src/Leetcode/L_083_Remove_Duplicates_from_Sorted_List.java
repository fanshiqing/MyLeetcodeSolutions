package Leetcode;

/**
 * Created by sqfan on 8/6/17.
 */
public class L_083_Remove_Duplicates_from_Sorted_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode (int x) { val = x; }
  }
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null) return head;
    ListNode p = head, prev = head.next;
    while (prev != null) {
      while (prev != null && prev.val == p.val) prev = prev.next;
      p.next = prev;
      p = p.next;
      if (prev != null) prev = prev.next;
    }
    return head;
  }
}
