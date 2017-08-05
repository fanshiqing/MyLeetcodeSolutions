package Offer;

/**
 * Created by sqfan on 8/4/17.
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class O_18_Has_Subtree {
  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }

  }

  public boolean HasSubtree(TreeNode root1,TreeNode root2) {
    boolean result = false;

    if (root1 != null && root2 != null) {
      if (root1.val == root2.val) {
        result = helper(root1.left, root2.left) && helper(root1.right, root2.right);
      }

      if (!result) return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);
    }

    return result;
  }
  private boolean helper(TreeNode root1, TreeNode root2) {
    if (root2 == null) return true;
    if (root1 == null) return false;

    if (root1.val != root2.val) return false;
    else return helper(root1.left, root2.left) && helper(root1.right, root2.right);

  }

  public static void main(String[] args) {
    TreeNode root1 = new TreeNode(0);
    root1.left = new TreeNode(1);
    root1.right = new TreeNode(2);
    root1.left.left = new TreeNode(3);
    root1.left.right = new TreeNode(4);
    root1.left.right.right = new TreeNode(5);

    TreeNode root2 = new TreeNode(4);
    root2.right = new TreeNode(5);
    O_18_Has_Subtree solution = new O_18_Has_Subtree();
    System.out.println(solution.HasSubtree(root1, root2));
  }
}
