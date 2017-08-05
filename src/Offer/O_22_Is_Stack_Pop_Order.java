package Offer;

import java.util.Stack;

/**
 * Created by sqfan on 8/5/17.
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 *
 */
public class O_22_Is_Stack_Pop_Order {
  /**
   * 思路：模拟栈压入、弹出的过程
   * @return
   */
  public boolean IsPopOrder(int [] pushA,int [] popA) {
    Stack<Integer> in = new Stack<>();

    for (int i = 0, j = 0; i < pushA.length; i++) {
      in.push(pushA[i]);
      while (!in.empty() && in.peek() == popA[j]) {
          in.pop();
          j++;
      }
    }

    return in.empty();
  }
}
