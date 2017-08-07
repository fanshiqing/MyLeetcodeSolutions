package Offer;

import java.util.ArrayList;
/**
 * Created by sqfan on 8/6/17.
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class O_25_Find_Path_in_Binary_Tree {
  public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
      this.val = val;
    }
  }
  public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
    ArrayList<ArrayList<Integer> > results = new ArrayList<ArrayList<Integer> >();
    ArrayList<Integer> path = new ArrayList<>();

    helper(root, target, results, path);

    return results;
  }

  private void helper(TreeNode root, int target, ArrayList<ArrayList<Integer> > results, ArrayList<Integer> path) {
    if (root == null) return;
    path.add(root.val);
    target -= root.val;
    if (root.left == null && root.right == null && target == 0) { // leaf node
        ArrayList<Integer> result = new ArrayList<>(path); // SHALLOW COPY!
        results.add(result);
    } else { // non-leaf node
      helper(root.left, target, results, path);
      helper(root.right, target, results, path);
    }

    path.remove(path.size() - 1);
    return ;
  }

  public static void main(String[] args) {
//    ArrayList<ArrayList<Integer> > outer = new ArrayList<ArrayList<Integer>>();
//    ArrayList<Integer> inner = new ArrayList<>();
//
//    inner.add(10);
//    inner.add(11);
//    ArrayList<Integer> inner2 = new ArrayList<>(inner);
//    outer.add(inner);
//    ArrayList<ArrayList<Integer> > outer2 = new ArrayList<ArrayList<Integer>>(outer);
//    System.out.println(outer);
//    inner.remove(new Integer(10));
//    System.out.println(inner);
//    System.out.println(outer);
//    System.out.println(inner2);
//    System.out.println(outer2);

    ArrayList<Integer> tmp = new ArrayList<>();
    tmp.add(1);
    ArrayList<Integer> tmp2 = new ArrayList<>(tmp);
    tmp.remove(tmp.size() - 1);
    System.out.println(tmp2);
  }
}
