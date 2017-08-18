package Offer;

/**
 * Created by sqfan on 8/18/17.
 */
public class O_58_InOrder_Traverse_Next_Node {
  public class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
      this.val = val;
    }
  }
  public TreeLinkNode GetNext(TreeLinkNode pNode)
  {
    if (pNode == null) return null;
    if (pNode.right == null) {
      TreeLinkNode p = pNode.next, prev = pNode;
      while (p != null) {
        if (p.left == prev) break;
        prev = p;
        p = p.next;
      }
      return p;
    } else {
      TreeLinkNode p = pNode.right;
      while (p.left != null) p = p.left;
      return p;
    }
  }
}
