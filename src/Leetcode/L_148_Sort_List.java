package Leetcode;

/**
 * Created by sqfan on 8/20/17.
 * 链表的merge sort.
 *    1. 将链表一切为二（快慢指针）
 *    2. 对左右2份递归调用
 *    3. merge左右两个已排序的list
 * 时间：O(nlog(n))
 * 空间：O(1)
 */
public class L_148_Sort_List {
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public ListNode sortList(ListNode head) {
    if (head == null || head.next == null) return head;

    ListNode slow = head, fast = head, prev = null;
    while (fast != null && fast.next != null) {
      prev = slow;
      fast = fast.next.next;
      slow = slow.next;
    }
    prev.next = null; // step1: cut the list into two parts!!!!

    ListNode l1 = sortList(slow);     // step 2. sort each half
    ListNode l2 = sortList(head);

    return merge(l1, l2);  // step 3. merge l1 and l2
  }
  public ListNode merge(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(-1);
    ListNode p = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    if (l1 != null) p.next = l1;
    if (l2 != null) p.next = l2;

    return dummyHead.next;
  }
  public static void main(String[] args) {
    ListNode head = new ListNode(-1);
    head.next = new ListNode(5);
    head.next.next = new ListNode(4);
    head.next.next.next = new ListNode(7);
    head.next.next.next.next = new ListNode(-2);

    L_148_Sort_List solution = new L_148_Sort_List();
    ListNode result = solution.sortList(head);
    while (result != null) {
      System.out.print(result.val + ", ");
      result = result.next;
    }
  }
}
