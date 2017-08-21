package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 * 从有序数组创建BST。
 * 时间：O(n)
 */
public class L_108_Convert_Sorted_Array_to_Binary_Search_Tree {
  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    return toBST(nums, 0, nums.length - 1);
  }
  public TreeNode toBST(int[] nums, int left, int right) {
    if (left > right) return null;
    int mid = (left + right) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = toBST(nums, left, mid - 1);
    root.right = toBST(nums, mid + 1, right);
    return root;
  }
}
