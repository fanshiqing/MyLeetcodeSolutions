package Leetcode.Tree;

import java.util.Stack;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_099_Recover_Binary_Search_Tree {
  // 中序遍历
  public static void recoverTree(TreeNode root) {
    if (root == null) return ;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    TreeNode wrong = null, cur = null;
    do {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        if (p.val < prev.val) {
          if (wrong == null) {
            wrong = prev;
            cur = p;
          } else {
            break;
          }
        }
        prev = p;
        p = p.right;
      }
    } while (p != null || !stack.isEmpty());
    if (p == null) p = cur;
    int tmp = wrong.val;
    wrong.val = p.val;
    p.val = tmp;
  }
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) { val = v; }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    recoverTree(root);
  }
}
