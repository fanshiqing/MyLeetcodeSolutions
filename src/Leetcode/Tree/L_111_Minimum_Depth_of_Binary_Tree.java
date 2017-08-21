package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_111_Minimum_Depth_of_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int minDepth(TreeNode root) {
    if (root == null) return 0;
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;

    int leftH = minDepth(root.left);
    int rightH = minDepth(root.right);
    return Math.min(leftH, rightH) + 1;
  }
}
