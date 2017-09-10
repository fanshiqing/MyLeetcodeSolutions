package Leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 怎样不使用额外数据结构而区分Queue中的节点level？.
 */
public class L_102_Binary_Tree_Level_Order_Traversal {
   public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) { val = x; }
  }
  class Element {
    TreeNode node;
    int level;
    Element(TreeNode n, int l) { node = n; level = l; }
  }
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> curLevel = null;
    Queue<Element> queue = new LinkedList<>();
    queue.add(new Element(root, 0));
    int lastLevel = -1;
    while (!queue.isEmpty()) {
      Element cur = queue.remove();
      if (cur.node == null) continue;

      if (cur.level > lastLevel) {
        lastLevel = cur.level;
        curLevel = new ArrayList<>();
        result.add(curLevel);
      }
      curLevel.add(cur.node.val);
      if (cur.node.left != null) queue.add(new Element(cur.node.left, cur.level + 1));
      if (cur.node.right != null) queue.add(new Element(cur.node.right, cur.level + 1));
    }

    return result;
  }

  ///////////////////////////////////////////////////////////////////////////////////

  /**
   * 因为每个节点处理时都会出队列。所以每次while新的一轮循环开始时当前queue的内容就是当前level的节点
   */
  public List<List<Integer>> levelOrder2(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) { // level-by-level processing!!!
      int levelSize = queue.size();
      List<Integer> levelVal = new LinkedList<>();
      for (int i = 0; i < levelSize; i++) {
        TreeNode node = queue.remove();
        levelVal.add(node.val);
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
      }
      result.add(levelVal);
    }

    return result;
  }

}
