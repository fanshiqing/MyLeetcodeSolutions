package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by sqfan on 8/6/17.
 * 二叉树的中序遍历，递归和非递归实现
 */
public class L_094_Binary_Tree_Inorder_Traversal {
  List<Integer> result = new ArrayList<Integer>();

  public List<Integer> inorderTraversal_Non_Recursive(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    do {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        result.add(p.val);
        p = p.right;
      }
    } while (p != null || !stack.isEmpty());
    return result;
  }

  public List<Integer> inorderTraversal(TreeNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      result.add(root.val);
      inorderTraversal(root.right);
    }
    return result;
  }

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int v) { val = v; }
  }
}
