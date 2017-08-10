package Leetcode;

/**
 * Created by sqfan on 8/10/17.
 */
public class L_264_Ugly_Number_II {
  /**
   * Time: O(n)
   * Space: O(n)
   */
  public int nthUglyNumber(int n) {
    if (n <= 0) throw new IllegalArgumentException("Illegal Argument");

    int i1 = 0, i2 = 0, i3 = 0;
    int c1 = 2, c2 = 3, c3 = 5;
    int[] ret = new int[n];
    ret[0] = 1;
    for (int i = 1; i < n; i++) {
      int min = Math.min(Math.min(c1, c2), c3);
      ret[i] = min;
      if (min == c1) c1 = 2 * ret[++i1];
      if (min == c2) c2 = 3 * ret[++i2]; // !!! BOTH CHECK in case of cases like: 1. 3x2 2. 2x3
      if (min == c3) c3 = 5 * ret[++i3];
    }

    return ret[n - 1];
  }

  public static void main(String[] args) {
    L_264_Ugly_Number_II solution = new L_264_Ugly_Number_II();
    System.out.println(solution.nthUglyNumber(10));
  }
}
