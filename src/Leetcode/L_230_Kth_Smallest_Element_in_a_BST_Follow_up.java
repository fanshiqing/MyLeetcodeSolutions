package Leetcode;

/**
 * Created by sqfan on 8/11/17.
 * What if the BST is modified (insert/delete operations) often and you need to
 * find the kth smallest frequently? How would you optimize the kthSmallest routine?
 * 思路： 如果BST节点TreeNode的属性可以扩展，则再添加一个属性leftCnt，记录树的节点个数。
 *  - 填充count域：O(n)
 *  - 插入/删除节点，要更新count: O(log(n))
 *  - 频繁查找第k个：O(log(n))
 */
public class L_230_Kth_Smallest_Element_in_a_BST_Follow_up {
  public class TreeNode {
    int val;
    int count = 1; // !!!DEFAULT VALUE!!!
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  /**
   * Init the `count` field.
   * @param root
   * @return
   */
  private void init(TreeNode root) {
    if (root == null) return ;
    root.count += (root.left == null ? 0 : root.left.count)
                   + (root.right == null ? 0 : root.right.count);
  }
  public int kthSmallest(TreeNode root, int k) {
    init(root); // O(n)
    if (root == null || k < 0 || k > root.count) return -1;

    return findKthSmallest(root, k);
  }

  private int findKthSmallest(TreeNode root, int k) {
    if (root == null) throw new IllegalArgumentException("illegal argument");
    if (root.left == null) {
      if (k == 1) return root.val;
      else return findKthSmallest(root.right, k - 1);
    }
    if (k == root.left.count + 1) return root.val;
    else if (k > root.left.count + 1) {
      return findKthSmallest(root.right, k - 1 - root.left.count);
    } else {
      return findKthSmallest(root.left, k);
    }
  }
}
