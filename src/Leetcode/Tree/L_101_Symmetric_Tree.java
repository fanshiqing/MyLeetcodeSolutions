package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_101_Symmetric_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public boolean isSymmetric(TreeNode root) {
    if (root == null) return true;

    return isSymm(root.left, root.right);
  }

  public boolean isSymm(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left != null && right != null) {
      return left.val == right.val && isSymm(left.left, right.right) && isSymm(left.right, right.left);
    } else {
      return false;
    }
  }
}
