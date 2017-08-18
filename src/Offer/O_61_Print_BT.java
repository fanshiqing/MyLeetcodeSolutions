package Offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by sqfan on 8/18/17.
 */
public class O_61_Print_BT {
  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }
  public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
    Stack<TreeNode> stack1 = new Stack<>();
    Stack<TreeNode> stack2 = new Stack<>();

    ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
    if (pRoot == null) return result;
    stack1.push(pRoot);
    do {
      ArrayList<Integer> list1 = new ArrayList<>();
      while (!stack1.isEmpty()) { // level-i traversal
        TreeNode p = stack1.pop();
        if (p == null) continue;
        list1.add(p.val);
        stack2.push(p.left); // left-to-right
        stack2.push(p.right);
      }
      if (!list1.isEmpty()) result.add(list1);
      ArrayList<Integer> list2 = new ArrayList<>();
      while (!stack2.isEmpty()) { // level-(i+1) traversal
        TreeNode p = stack2.pop();
        if (p == null) continue;
        list2.add(p.val);
        stack1.push(p.right); // right-to-left
        stack1.push(p.left);
      }
      if (!list2.isEmpty()) result.add(list2);
    } while (!stack1.isEmpty() || !stack2.isEmpty());

    return result;
  }
}
