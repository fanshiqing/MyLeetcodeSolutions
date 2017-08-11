package Leetcode;

/**
 * Created by sqfan on 8/12/17.
 */
public class L_029_Divide_Two_Integers {
  /**
   * 注意：Math.abs(Integer.MIN_VALUE)的返回值是Integer.MIN_VALUE
   */
  public int divide(int dividend, int divisor) {
    if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
    int sign = ((dividend > 0) ^ (divisor > 0)) ? -1 : 1;
    long la = Math.abs((long)dividend);
    long lb = Math.abs((long)divisor);
    long result = 0;
    while (la >= lb) {
      long m = 1;
      long t = lb;
      while (la >= (t << 1)) {
        m = m << 1;
        t = t << 1;
      }
      result += m;
      la -= t;
    }
    return (sign == 1) ? (int)result : -(int)result;
  }

  public static void main(String[] args) {
    L_029_Divide_Two_Integers solution = new L_029_Divide_Two_Integers();
    assert(solution.divide(10, 3) == 3);
    assert(solution.divide(10, 0) == Integer.MAX_VALUE);
    assert(solution.divide(10, 11) == 0);
    assert(solution.divide(10, -3) == -3);
    assert(solution.divide(Integer.MIN_VALUE, 1) == 0);
    System.out.println(solution.divide(Integer.MIN_VALUE, 1));
  }
}
