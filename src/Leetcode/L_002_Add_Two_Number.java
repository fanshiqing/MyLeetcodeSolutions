package Leetcode;

/**
 * Created by sqfan on 8/6/17.
 */
public class L_002_Add_Two_Number {

   public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
   }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode result = new ListNode(-1); // Dummy Head
      ListNode p1 = l1, p2 = l2, p = result;
      int carry = 0;
      int sum = 0;
      while (p1 != null || p2 != null || carry != 0) {
        sum = (p1 != null ? p1.val : 0) + (p2 != null ? p2.val : 0) + carry;
        carry = sum / 10;
        p.next = new ListNode(sum % 10);
        p = p.next;
        if (p1 != null) p1 = p1.next;
        if (p2 != null) p2 = p2.next;
      }
      return result.next;
    }
}
