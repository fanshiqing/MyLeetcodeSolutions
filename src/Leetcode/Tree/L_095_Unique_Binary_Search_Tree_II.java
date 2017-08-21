package Leetcode.Tree;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by sqfan on 8/21/17.
 */
public class L_095_Unique_Binary_Search_Tree_II {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
///////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * DP-解法.
   * 特别注意：在调用dp[j-1],dp[i-j]的子问题时，右子树的node.val都要偏移j个单位！而左子树都是从1开始计数，
   *          所以不用处理。
   */
  public List<TreeNode> generateTrees_DP(int n) {
    if (n < 1) return new ArrayList<TreeNode>();

    ArrayList<TreeNode>[] dp = new ArrayList[n+1];
    dp[0] = new ArrayList<TreeNode>();
    dp[0].add(null);
    for (int i = 1; i <= n; i++) {
      dp[i] = new ArrayList<TreeNode>();
      for (int j = 1; j <= i; j++) {
        List<TreeNode> lTree = dp[j-1];
        List<TreeNode> rTree = dp[i-j];
        for (TreeNode lRoot : lTree) {
          for (TreeNode rRoot : rTree) {
            TreeNode root = new TreeNode(j);
            root.left = lRoot;
            root.right = offsetCopy(rRoot, j);
            dp[i].add(root);
          }
        }
      }
    }
    return dp[n];
  }

  public TreeNode offsetCopy(TreeNode root, int offset) {
    if (root == null) return root;
    TreeNode rCopy = new TreeNode(root.val + offset);
    rCopy.left = offsetCopy(root.left, offset);
    rCopy.right = offsetCopy(root.right, offset);
    return rCopy;
  }

  public List<TreeNode> generateTrees(int n) {
    if (n < 1) return new ArrayList<TreeNode>();
    return generate(1, n);
  }
  public List<TreeNode> generate(int left, int right) {
    List<TreeNode> result = new ArrayList<>();
    if (left > right) {
      result.add(null);
      return result;
    }
    if (left == right) {
      result.add(new TreeNode(left));
      return result;
    }
    for (int root = left; root <= right; root++) {
      List<TreeNode> lTree = generate(left, root-1);
      List<TreeNode> rTree = generate(root+1, right);
      for (TreeNode l : lTree) {
        for (TreeNode r : rTree) {
          TreeNode cur = new TreeNode(root);
          cur.left = l;
          cur.right = r;
          result.add(cur);
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    L_095_Unique_Binary_Search_Tree_II solution = new L_095_Unique_Binary_Search_Tree_II();
    List<TreeNode> result = solution.generateTrees_DP(2);
    System.out.println("Done!");
  }
}
