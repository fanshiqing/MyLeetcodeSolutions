package Offer;

/**
 * Created by sqfan on 8/3/17.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 */
public class O_09_Fibonacci {
  /**
   * 时间：O(n)
   * 空间：O(n)
   */
  public int Fibonacci(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int[] result = new int[n + 1];
    result[0] = 0;
    result[1] = 1;
    for (int i = 2; i <= n; i++) {
      result[i] = result[i - 1] + result[i - 2];
    }
    return result[n];
  }

  /**
   * 不用临时数组来存放中间结果.
   * 时间：O(n)
   * 空间：O(1)
   */
  public int Fibonacci2(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    int a = 0, b = 1;
    while (--n > 0) {
      b = a + b;
      a = b - a;
    }
    return b;
  }

    public int JumpFloorII(int target) {
      int ret = 1;
      while (--target > 0) {
        ret *= 2;
      }
      return ret;
    }
}
