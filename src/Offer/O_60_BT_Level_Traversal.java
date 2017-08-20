package Offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by sqfan on 8/18/17.
 */
public class O_60_BT_Level_Traversal {
  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }
  ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer> >();
    if (pRoot == null) return result;

    Queue<TreeNode> q1 = new LinkedList<TreeNode>();
    Queue<TreeNode> q2 = new LinkedList<TreeNode>();
    q1.add(pRoot);
    while (!q1.isEmpty() || !q2.isEmpty()) {
      ArrayList<Integer> list1 = new ArrayList<>();
      while (!q1.isEmpty()) {
        TreeNode p = q1.remove();
        if (p == null) continue;
        list1.add(p.val);
        if (p.left != null) q2.add(p.left);
        if (p.right != null) q2.add(p.right);
      }
      if (!list1.isEmpty()) result.add(list1);

      ArrayList<Integer> list2 = new ArrayList<>();
      while (!q2.isEmpty()) {
        TreeNode p = q2.remove();
        if (p == null) continue;
        list2.add(p.val);
        if (p.left != null) q1.add(p.left);
        if (p.right != null) q1.add(p.right);
      }
      if (!list2.isEmpty()) result.add(list2);
    }
    return result;
  }
}
