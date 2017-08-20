package Leetcode;

/**
 * Created by sqfan on 8/20/17.
 * 对一个链表进行Partition操作，使得所有val小于x的node在前，>=x节点在后。要求节点间相对顺序不变。
 * 思路：维护两个链表ltList,geList;单趟扫描原链表，< x的节点接入ltList, >= x的节点接入geLsit. 最后将
 *      ltList和geList拼接，并置geList尾节点next域为null(否则新链表可能产生环).
 */
public class L_086_Partition_List {
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  /**
   * Time: O(n)
   * Space: O(1)
   */
  public ListNode partition(ListNode head, int x) {
    ListNode ltList = new ListNode(-1);
    ListNode geList = new ListNode(-1);
    ListNode p1 = ltList, p2 = geList;

    while (head != null) {
      if (head.val < x) {
        p1.next = head;
        p1 = p1.next;
      } else {
        p2.next = head;
        p2 = p2.next;
      }
      head = head.next;
    }
    p1.next = geList.next;
    p2.next = null;
    return ltList.next;
  }
}
