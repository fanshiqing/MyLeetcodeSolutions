package Offer;

/**
 * Created by sqfan on 8/5/17.
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同
 *
 * 思路：BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 *          如果去掉最后一个元素的序列为T，那么T满足：
 *          T可以分成两段，前一段（左子树）小于x，后一段（右子树）大于x
 */
public class O_24_Verify_Sequence_of_BST {

  public boolean VerifySquenceOfBST(int [] sequence) {
    if (sequence.length == 0) return false; // ->_->
    return helper(sequence, 0, sequence.length - 1);
  }
  private boolean helper (int[] sequence, int start, int end) {
    if (start >= end) return true;
    int root = sequence[end];
    int split = start;
    while (split < end && sequence[split] < root) split++;

    int t = split;
    while (t < end && sequence[t] > root) t++;
    if (t != end) return false;
    return helper(sequence, start, split-1) && helper(sequence, split, end-1);

  }

  public static void main(String[] args) {
    O_24_Verify_Sequence_of_BST solution = new O_24_Verify_Sequence_of_BST();
    int[] array = {3,1,2};
//    int[] array = {2,4,5,9,3};
//    int[] array = {};
//    int[] array = {2,4,9,5,3};
    boolean result = solution.VerifySquenceOfBST(array);
    System.out.println(result);
  }
}
