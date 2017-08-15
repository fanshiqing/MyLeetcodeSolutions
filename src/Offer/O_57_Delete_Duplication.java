package Offer;

/**
 * Created by sqfan on 8/15/17.
 */
public class O_57_Delete_Duplication {
  public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  /**
   * 递归解法。
   * 时间：O(n)
   * 空间：O(1)
   * @param pHead
   * @return
   */
  public ListNode deleteDuplication(ListNode pHead)
  {
    if (pHead == null || pHead.next == null) return pHead;
    if (pHead.val != pHead.next.val) {
      pHead.next = deleteDuplication(pHead.next);
      return pHead;
    } else {
      ListNode p = pHead.next;
      while (p != null && p.val == pHead.val) p = p.next;
      return deleteDuplication(p);
    }
  }
}
