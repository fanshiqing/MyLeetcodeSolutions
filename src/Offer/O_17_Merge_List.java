package Offer;

/**
 * Created by sqfan on 8/4/17.
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class O_17_Merge_List {
    class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
        this.val = val;
      }
    }

  /**
   * 递归解法！
   * 时间：O(n)
   * 空间：O(n)
   */
    public ListNode Merge(ListNode list1,ListNode list2) {
      if (list1 == null) return list2;
      if (list2 == null) return list1;

      if (list1.val <= list2.val) {
        list1.next = Merge(list1.next, list2);
        return list1;
      } else {
        list2.next = Merge(list1, list2.next);
        return list2;
      }
    }

  /**
   * 非递归解法
   * 时间：O(n）
   * 空间：O(1)
   */
  public ListNode Merge2(ListNode list1,ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    ListNode head = null;
    if (list1.val <= list2.val) {
      head = list1;
      list1 = list1.next;
    } else {
      head = list2;
      list2 = list2.next;
    }
    ListNode p = head;
    while (list1 != null && list2 != null) {
      if (list1.val <= list2.val) {
        p.next = list1;
        list1 = list1.next;
      } else {
        p.next = list2;
        list2 = list2.next;
      }
      p = p.next;

    }

    if (list1 == null) p.next = list2;
    else p.next = list1;

    return head;
  }
}
