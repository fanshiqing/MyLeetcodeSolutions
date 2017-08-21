package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 * 从有序链表创建BST。
 * 每次用快/慢指针将list一分为二，递归处理左右子树，中间的节点即为root
 * 时间：O(nlog(n))
 */
public class L_109_Convert_Sorted_List_to_Binary_Search_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
  public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  /**
   * 注意本解法修改了输入head的结构！
   * 如果不想修改list就要在单趟扫描时手动加上tail
   */
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode prev = null, slow = head, fast = head;
    while (fast != null && fast.next != null) {
      prev = slow;
      slow = slow.next;
      fast = fast.next.next;
    }
    prev.next = null; // split the list input [left, head, right] parts
    TreeNode root = new TreeNode(slow.val);
    root.left = sortedListToBST(head);
    root.right = sortedListToBST(slow.next);
    return root;
  }

  /**
   * 不修改输入list
   */
  public TreeNode sortedListToBST2(ListNode head) {
    return toBST(head, null);
  }
  public TreeNode toBST(ListNode head, ListNode tail) {
    if (head == tail) return null;
    if (head.next == tail) return new TreeNode(head.val);
    ListNode fast = head;
    ListNode slow = head;
    while (fast != tail && fast.next != tail) {
      slow = slow.next;
      fast = fast.next.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = toBST(head, slow);
    root.right = toBST(slow.next, tail);
    return root;
  }
}
