package Offer;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Created by sqfan on 8/2/17.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 思路：1. 递归操作，实现了从尾到头打印(缺点：链表较长时不适用)
 *      2. 先正向遍历，然后使用Collections.reverse()逆序
 */

public class O_05_Print_List_From_Tail_2_Head {
  static class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
      this.val = val;
    }
  }

  /**
   * 时间：O(n)
   * 空间：O(n)
   */
  public ArrayList<Integer> solution(ListNode listNode) {
    if (listNode == null) return new ArrayList<Integer>();

    ArrayList<Integer> ret = solution(listNode.next);
    ret.add(listNode.val);
    return ret;
  }

  public ArrayList<Integer> solution2(ListNode listNode) {
    ListNode p = listNode;
    ArrayList<Integer> ret = new ArrayList<>();
    while (p != null) {
      ret.add(p.val);
      p = p.next;
    }
    Collections.reverse(ret); // !!!  Collections.reverse()
    return ret;
  }

  public static void main(String[] args) {
    O_05_Print_List_From_Tail_2_Head solution = new O_05_Print_List_From_Tail_2_Head();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    ArrayList<Integer> ret = solution.solution2(head);
    System.out.println(ret);
  }
}
