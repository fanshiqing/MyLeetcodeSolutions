package Offer;

import java.util.Stack;

/**
 * Created by sqfan on 8/6/17.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *    要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class O_27_BST_to_Double_Linked_List {
  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  /**
   * 递归版，模仿中序遍历。
   * 时间：O(n)
   * 空间：O(n) (递归调用栈)
   */
  public TreeNode Convert(TreeNode root) {
    if (root == null) return root;

    TreeNode leftHead = Convert(root.left);
    TreeNode p = leftHead;
    while (leftHead != null && leftHead.right != null) leftHead = leftHead.right;
    if (leftHead != null) {
      root.left = leftHead;
      leftHead.right = root;
    }
    TreeNode rightHead = Convert(root.right);
    if (rightHead != null) {
      root.right = rightHead;
      rightHead.left = root;
    }

    return (p == null ? root : p); // return the head
  }

  /**
   * 非递归解法（二叉树中序遍历的非递归形式）,使用stack保存中间节点，pre保存双向链表中前驱节点
   * 时间：O(n)
   * 空间：O(n)
   */
  public TreeNode Convert2(TreeNode root) {
    TreeNode result = null, pre = null;
    Stack<TreeNode> stack = new Stack<>();
    TreeNode p = root;
    do {
      while (p != null) {
        stack.push(p);
        p = p.left;
      }
      if (!stack.isEmpty()) {
        p = stack.pop();
        if (pre == null) { // The head found
          pre = p;
          result = p;
        } else {
          p.left = pre;
          pre.right = p;
          pre = p;
        }
        p = p.right;
      }
    } while (p != null || !stack.isEmpty());
    return result;
  }

  public static void main(String[] args) {
    O_27_BST_to_Double_Linked_List solution = new O_27_BST_to_Double_Linked_List();

    TreeNode root = new TreeNode(10);
    root.left = new TreeNode(6);
    root.right = new TreeNode(14);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(8);
    root.right.left = new TreeNode(12);
    root.right.right = new TreeNode(16);

    TreeNode result = solution.Convert2(root);
//    TreeNode result = solution.Convert(root);
    System.out.println("Done!");
  }


}
