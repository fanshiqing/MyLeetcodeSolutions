package Offer;

/**
 * Created by sqfan on 8/7/17.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 平衡二叉树：父节点的左子树和右子树的高度之差不能大于1。
 */
public class O_39_Is_Balanced_Tree {
  /**
   * 传统递归解法。
   * 缺点：重复遍历了节点，效率低下。
   */
  public boolean IsBalanced_Solution(TreeNode root) {
    if (root == null) return true;
    if (IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right) && Math.abs(depth(root.left) - depth(root.right)) <= 1) return true;
    return false;
  }
  public int depth(TreeNode root) {
    if (root == null) return 0;
    else return 1 + Math.max(depth(root.left), depth(root.right));
  }

  /**
   * 后续遍历
   */
  public boolean IsBalanced_Solution2(TreeNode root) {
    return height(root) != -1;
  }

  private int height(TreeNode root) {
    if (root == null) return 0;
    int h1 = height(root.left);
    int h2 = height(root.right);
    if (h1 == -1 || h2 == -1 || Math.abs(h1 - h2) > 1) return -1; // unbalanced!
    return Math.max(h1, h2) + 1;
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
