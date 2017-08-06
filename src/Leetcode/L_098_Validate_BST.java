package Leetcode;

import java.util.Stack;

/**
 * Created by sqfan on 8/6/17.
 * 判定一棵二叉树是否是二叉搜索树。
 */
public class L_098_Validate_BST {
  public boolean isValidBST(TreeNode root) {
    int prev = Integer.MIN_VALUE;
    boolean init = false;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    do {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        if (!init) {
          prev = p.val;
          init = true;
        } else if (prev >= p.val) return false; // !!!!注意BST是严格小于

        prev = p.val;
        p = p.right;
      }
    } while (p != null || !stack.isEmpty());

    return true;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) { val = v; }
  }
}
