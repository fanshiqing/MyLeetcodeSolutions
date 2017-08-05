package Offer;

import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;
/**
 * Created by sqfan on 8/2/17.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class O_07_Two_Stack_For_Queue {
  Stack<Integer> stack1 = new Stack<Integer>();
  Stack<Integer> stack2 = new Stack<Integer>();

  public void push(int node) {
    stack1.push(node);
  }

  public int pop() {
    if (!stack2.empty()) return stack2.pop();
    else if (!stack1.empty()){
      while (!stack1.empty()) {
        stack2.push(stack1.pop());
      }
      return stack2.pop();
    } else { // 队列为空！
      throw new RuntimeException("Queue is empty!"); // !!!!
    }
  }

  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>();
    queue.peek();

  }
}
