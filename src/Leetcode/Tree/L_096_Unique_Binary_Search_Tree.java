package Leetcode.Tree;

/**
 * Created by sqfan on 8/21/17.
 * 求序列1...n的不同BST树的表示数目？
 * 思路：DP
 */
public class L_096_Unique_Binary_Search_Tree {
  public int numTrees(int n) {
    if (n < 1) throw new IllegalArgumentException("illegal argument");
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        dp[i] += dp[j-1] * dp[i - j];
      }
    }
    return dp[n];
  }
}
