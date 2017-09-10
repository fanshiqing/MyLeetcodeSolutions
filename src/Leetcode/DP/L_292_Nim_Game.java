package Leetcode.DP;

/**
 * 尼姆游戏：
 *    给我们一堆石子，每次可以拿一个两个或三个，两个人轮流拿，拿到最后一个石子的人获胜，现在给我们一堆石子的个数，
 *    问我们能不能赢。
 */
public class L_292_Nim_Game {
  /**
   * 递归解法，会超时。
   */
  public static boolean canWinNim(int n) {
    if (n <= 3) return true;
    return !(canWinNim(n-1) && canWinNim(n-2) && canWinNim(n-3));
  }

  /**
   * DP- Memory Limit Exception
   * 时间：O(n)
   * 空间：O(n)
   */
  public static boolean canWinNim_DP(int n) {
    if (n <= 3) return true;
    boolean[] dp = new boolean[n+1];
    dp[0] = dp[1] = dp[2] = dp[3] = true;
    for (int i = 4; i <= n; i++) {
      dp[i] = !(dp[i-1] && dp[i-2] && dp[i-3]);
    }
    return dp[n];
  }

  /**
   * 空间从O(n)缩成O(1).
   * 时间：O(n)
   * 空间：O(1)
   */
  public boolean canWinNim_DP2(int n) {
    if (n <= 3) return true;
    boolean r1 = true, r2 = true, r3 = true, ret = false;
    for (int i = 4; i <= n; i++) {
      ret = !(r1 && r2 && r3);
      r1 = r2;
      r2 = r3;
      r3 = ret;
    }
    return ret;
  }

  /**
   * 发现规律：4的倍数失败
   * 时间&空间： O(1)
   */
  public boolean canWinNim_Rule(int n) {
    return n == 0 || !(n % 4 == 0);
  }

  public static void main(String[] args) {
    System.out.println(canWinNim(5));
    System.out.println(canWinNim_DP(5));
    System.out.println(canWinNim(12));
    System.out.println(canWinNim_DP(12));
    for (int i = 1; i < 15; i++) {
      System.out.print(canWinNim(i) + ", ");
    }
  }
}
