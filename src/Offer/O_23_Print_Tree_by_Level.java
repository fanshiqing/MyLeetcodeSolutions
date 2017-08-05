package Offer;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by sqfan on 8/5/17.
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 * 思路：借助队列，按层操作
 */
public class O_23_Print_Tree_by_Level {
  public static class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }

  public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      TreeNode cur = queue.remove(); // queue.remove() vs. queue.poll(): 返回值不同
      if (cur != null) {
        result.add(cur.val);
        queue.add(cur.left);
        queue.add(cur.right);
      }
    }
    return result;
  }

  public static void main(String[] args) {

  }
}
