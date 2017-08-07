package Offer;


/**
 * Created by sqfan on 8/7/17.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，
 *    最长路径的长度为树的深度。
 */
public class O_39_Binary_Tree_Depth {
  public static int TreeDepth(TreeNode root) {
    if (root == null) return 0;
    else return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
  }

  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }
}
