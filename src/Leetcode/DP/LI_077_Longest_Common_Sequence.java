package Leetcode.DP;

/**
 * 最长公共子序列问题。(from LintCode-77)
 */
public class LI_077_Longest_Common_Sequence {
  /**
   * 递推公式：
   *    dp[i][j] = max{ dp[i][j-1], dp[i-1][j], if(str[i]==str[j]) dp[i-1][j-1]+1 };
   *
   * 时间：O(m*n)
   * 空间：O(m*n)
   * @param A
   * @param B
   * @return The length of longest common subsequence of A and B.
   */
  public static int longestCommonSubsequence(String A, String B) {
    if (A.length() == 0 || B.length() == 0) return 0;
    char[] str1 = A.toCharArray();
    char[] str2 = B.toCharArray();
    // dp[i][j]表示str1[0..i]与str2[0..j]的最长公共子序列长度
    int[][] dp = new int[str1.length][str2.length];
    dp[0][0] = (str1[0] == str2[0] ? 1 : 0);
    int LCS = dp[0][0];
    for (int i = 1; i < str1.length; i++) {
      dp[i][0] = Math.max(dp[i-1][0], str1[i] == str2[0] ? 1:0);
    }
    for (int j = 1; j < str2.length; j++) {
      dp[0][j] = Math.max(dp[0][j-1], str2[j] == str1[0] ? 1:0);
    }
    for (int i = 1; i < str1.length; i++) {
      for (int j = 1; j < str2.length; j++) {
        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        if (str1[i] == str2[j]) {
          dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
        }
        LCS = Math.max(LCS, dp[i][j]);
      }
    }
    return LCS;
  }

  public static void main(String[] args) {
    String s1 = "ABC123";
    String s2 = "A12E";
    System.out.println(longestCommonSubsequence(s1, s2));
  }
}
