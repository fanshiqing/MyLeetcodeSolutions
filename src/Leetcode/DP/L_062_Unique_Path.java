package Leetcode.DP;

/**
 * Created by sqfan on 8/20/17.
 */
public class L_062_Unique_Path {
  /**
   * 2D-DP
   * 时间：O(m*n)
   * 空间：O(m*n)
   */
  public static int uniquePaths(int m, int n) {
    int[][] dp = new int[m][n];
    for (int i = 0; i < m; i++) dp[i][0] = 1;
    for (int j = 0; j < n; j++) dp[0][j] = 1;

    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i][j-1] + dp[i-1][j];
      }
    }
    return dp[m-1][n-1];
  }

  /**
   * 改进：计算方向从上到下，从左到右即可。可以用滚动数组实现。空间复杂度：O(m*n)-->O(m)
   * 时间：O(m*n)
   * 空间：O(min(m, n))
   */
  public static int uniquePaths2(int m, int n) {
    if (m > n) return uniquePaths(n, m);
    int[] dp = new int[m];
    for (int i = 0; i < m; i++) dp[i] = 1;
    for (int j = 1; j < n; j++) {
      for (int i = 1; i < m; i++) {
        dp[i] += dp[i-1];
      }
    }
    return dp[m-1];
  }
  public static void main(String[] args) {
    System.out.println(uniquePaths(7, 3));
    System.out.println(uniquePaths2(7, 3));
  }
}
