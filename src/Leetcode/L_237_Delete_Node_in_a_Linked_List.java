package Leetcode;

/**
 * Created by sqfan on 8/15/17.
 */
public class L_237_Delete_Node_in_a_Linked_List {
   public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
  public void deleteNode(ListNode node) {
    if (node.next == null) throw new IllegalArgumentException("Illegal Argument");
    ListNode p = node.next;
    node.next = p.next;
    node.val = p.val;
  }
}
