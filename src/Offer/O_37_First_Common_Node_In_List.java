package Offer;

import java.util.HashSet;

/**
 * Created by sqfan on 8/10/17.
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class O_37_First_Common_Node_In_List {
  public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }

  /**
   * 改进的解法。循环扫描两个链表。当其中一个扫描至尾巴时调到另外一条链表上（变成*追逐问题*），
   * 这样的操作是为了处理两条链不等长的情况。若无公共节点，则返回null。第一次相遇的节点便是第一个公共节点。
   */
  public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    ListNode p1 = pHead1;
    ListNode p2 = pHead2;
    while (p1 != p2) {
      p1 = (p1 == null) ? pHead2 : p1.next;
      p2 = (p2 == null) ? pHead1 : p2.next;
    }
    return p1;
  }
  /**
   * 先扫描得到两个链表的长度，再对齐后一起扫描直到找到第一个公共节点
   * 时间：O(m+n)
   * 空间：O(1)
   */
  public ListNode FindFirstCommonNode2(ListNode pHead1, ListNode pHead2) {
    int len1 = 0, len2 = 0;
    ListNode p = pHead1;
    while (p != null) {
      len1 ++;
      p = p.next;
    }
    p = pHead2;
    while (p != null) {
      len2 ++;
      p = p.next;
    }
    ListNode p2;
    int abs = Math.abs(len1 - len2);
    if (len1 < len2) {
      p = pHead2;
      p2 = pHead1;
    } else {
      p = pHead1;
      p2 = pHead2;
    }
    while (abs-- > 0) p = p.next;
    while (p != p2 && p != null) {
      p = p.next;
      p2 = p2.next;
    }
    return p;
  }

  /**
   * HashSet保存第一条链表节点，再扫描第二条链表并检查hashset
   * 时间：O(m+n)
   * 空间：O(m)
   */
  public ListNode FindFirstCommonNode3(ListNode pHead1, ListNode pHead2) {
    ListNode p = pHead1;
    HashSet<ListNode> set = new HashSet<>();
    while (p != null) {
      set.add(p);
      p = p.next;
    }
    p = pHead2;
    while (p != null) {
      if (set.contains(p)) return p;
      p = p.next;
    }
    return null;
  }
}
