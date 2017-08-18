package Offer;

/**
 * Created by sqfan on 8/17/17.
 */
public class O_46_Sum {
  public static int Sum_Solution(int n) {
    int ans = n;
    boolean s = ans > 0 && (ans += Sum_Solution(n - 1)) == 0;
    return ans;
  }

  public static void main(String[] args) {
    int n = 3;
    System.out.print(Sum_Solution(n));
  }
}
