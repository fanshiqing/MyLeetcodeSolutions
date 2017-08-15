package Offer;

/**
 * Created by sqfan on 8/15/17.
 */
public class O_45_Josephus {
  public int LastRemaining_Solution(int n, int m) {
    if (n < 1 || m < 1) return -1;
    int a = 0;
    for (int i = 1; i < n; i++) {
      a = (a + m) % (i+1);
    }
    return a;
  }
}
