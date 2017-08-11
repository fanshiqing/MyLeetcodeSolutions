package Leetcode;

import java.util.Stack;

/**
 * Created by sqfan on 8/11/17.
 */
public class L_230_Kth_Smallest_Element_in_a_BST {
  /**
   * BST中序遍历的非递归实现。
   * 时间：O(n)
   * 空间：O(n)
   */
  public int kthSmallest(TreeNode root, int k) {
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    do {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        k--;
        if (k == 0) return p.val;
        p = p.right;
      }
    } while (p != null || !stack.isEmpty());
    return -1; // not found
  }
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
