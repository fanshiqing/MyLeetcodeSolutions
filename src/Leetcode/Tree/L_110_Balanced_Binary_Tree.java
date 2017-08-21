package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_110_Balanced_Binary_Tree {
   public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }

  public boolean isBalanced(TreeNode root) {
    return dfs(root) != -1;
  }
  public int dfs(TreeNode root) {
    if (root == null) return 0;
    int leftHeight = dfs(root.left);
    if (leftHeight == -1) return -1;
    int rightHeight = dfs(root.right);
    if (rightHeight == -1) return -1;
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    return Math.max(leftHeight, rightHeight) + 1;
  }
}
