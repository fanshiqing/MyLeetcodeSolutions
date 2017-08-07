package Leetcode;

import java.util.Stack;

/**
 * Created by sqfan on 8/6/17.
 */
public class L_100_Is_Same_Tree {
  /**
   * 非递归实现，中序遍历
   */
  public boolean isSameTree(TreeNode p, TreeNode q) {
    Stack<TreeNode> stk1 = new Stack<>();
    Stack<TreeNode> stk2 = new Stack<>();
    stk1.push(p);
    stk2.push(q);
    while (!stk1.isEmpty() && !stk2.isEmpty()) {
      p = stk1.pop();
      q = stk2.pop();
      if (p == null && q == null) continue;
      if ((p == null || q == null) || p.val != q.val) return false;
      stk1.push(p.right);
      stk2.push(q.right);
      stk1.push(p.left);
      stk2.push(q.left);
    }

    return stk1.isEmpty() && stk2.isEmpty();
  }

  /**
   * 递归实现
   */
  public boolean isSameTree2(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p != null && q != null) {
      return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    return false;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) { val = v; }
  }
}
