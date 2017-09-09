package Leetcode.DP;

/**
 * Created by sqfan on 9/9/17.
 */
public class L_070_Climbing_Stairs {
  public int climbStairs(int n) {
    if (n < 2) return 1; // 注意梯子有n个台阶
    int a = 1, b = 1;
    for (int i = 2; i <= n; i++) {
      b = a + b;
      a = b - a;
    }
    return b;
  }
}
