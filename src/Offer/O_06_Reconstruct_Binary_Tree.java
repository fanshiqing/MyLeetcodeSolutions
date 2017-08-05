package Offer;

/**
 * Created by sqfan on 8/2/17.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 */


public class O_06_Reconstruct_Binary_Tree {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val;}
  }

  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    int size = pre.length;
    return helper(pre, 0, size - 1, in, 0, size - 1);
  }

  public TreeNode helper(int [] pre, int l1, int r1, int[] in, int l2, int r2) {
    if (l1 > r1) return null;  // 注意边界情况！
    TreeNode root = new TreeNode(pre[l1]);
    int split = l2;
    while (in[split] != pre[l1]) {
      split ++;
    }
    root.left = helper(pre, l1 + 1, l1 + split - l2, in, l2, split - 1);
    root.right = helper(pre, l1 + split - l2 + 1, r1, in, split + 1, r2);

    return root;
  }

  public static void main(String[] args) {
    O_06_Reconstruct_Binary_Tree solution = new O_06_Reconstruct_Binary_Tree();

//    int[] pre = {1,2};
//    int[] in = {1,2};
    int[] pre = {1,2,4,7,3,5,6,8};
    int[] in = {4,7,2,1,5,3,8,6};
    TreeNode root = solution.reConstructBinaryTree(pre, in);
    System.out.println("Done!");
  }
}
