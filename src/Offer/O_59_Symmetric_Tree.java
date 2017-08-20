package Offer;

/**
 * Created by sqfan on 8/18/17.
 */
public class O_59_Symmetric_Tree {
  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  boolean isSymmetrical(TreeNode root)
  {
    if (root == null) return true;
    return isSymm(root.left, root.right);
  }
  private boolean isSymm(TreeNode left, TreeNode right) {
    if (left == null && right == null) return true;
    if (left == null || right == null) return false;

    return left.val == right.val
        && isSymm(left.left, right.right)
        && isSymm(left.right, right.left);
  }
}
