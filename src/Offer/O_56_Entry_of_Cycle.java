package Offer;

/**
 * Created by sqfan on 8/15/17.
 */
public class O_56_Entry_of_Cycle {
  public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  public ListNode EntryNodeOfLoop(ListNode pHead)
  {
    ListNode fast = pHead, slow = pHead;
    while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) break;
    }
    if (fast == null || fast.next == null) return null;
    fast = pHead;
    while (fast != slow) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }
}
