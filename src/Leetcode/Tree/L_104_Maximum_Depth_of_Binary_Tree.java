package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_104_Maximum_Depth_of_Binary_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public int maxDepth(TreeNode root) {
    return dfs(root);
  }

  private int dfs(TreeNode root) {
    if (root == null) return 0;
    int leftDepth = dfs(root.left);
    int rightDepth = dfs(root.right);

    return Math.max(leftDepth, rightDepth) + 1;
  }
}
