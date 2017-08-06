package Offer;

import java.util.HashMap;

/**
 * Created by sqfan on 8/6/17.
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 *    返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class O_26_Clone_Random_List {
  public class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
      this.label = label;
    }
  }

  /**
   * 思路①：Step1. 根据next复制链表，用map记录新旧节点映射；
   *      Step2. 扫描链表，根据map记录填充random域
   * 时间：O(n)
   * 空间：O(n)
   */
  public RandomListNode Clone(RandomListNode pHead) {
    HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode p1 = pHead, p2 = null, tail = null;
    RandomListNode result = null;

    while (p1 != null) {
      p2 = new RandomListNode(p1.label);
      map.put(p1, p2);
      if (result == null) {
        tail = p2;
        result = tail;
      }
      else {
        tail.next = p2;
        tail = p2;
      }
      p1 = p1.next;
    }
    // Fill the random field
    p1 = pHead;
    p2 = result;
    while (p1 != null) {
      p2.random = map.get(p1.random);

      p1 = p1.next;
      p2 = p2.next;
    }

    return result;
  }
  /**
   * 改进思路②：创建新链表的时候，用原结点的next指针指向对应新结点，新结点的next指针指向下一个原结点，
   *            以此类推，形成之字形关联，从而节省了解法1中的map的O(n)空间开销。
   * 时间：O(n)
   * 空间：O(1)
   */
  public RandomListNode Clone2(RandomListNode pHead)
  {
    RandomListNode p1 = pHead, tail = null;
    RandomListNode result = new RandomListNode(-1);
    while (p1 != null) {
      RandomListNode cur = new RandomListNode(p1.label);
      cur.next = p1.next;
      p1.next = cur;

      p1 = p1.next.next;
    }

    p1 = pHead;
    while (p1 != null) {
      if (p1.random != null) p1.next.random = p1.random.next;
      p1 = p1.next.next;
    }
    p1 = pHead;
    tail = result;
    while (p1 != null) {
      tail.next = p1.next;
      tail = tail.next;
      p1.next = tail.next;

      p1 = p1.next;
    }
    return result.next;
  }
}
