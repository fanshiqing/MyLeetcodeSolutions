package Leetcode.DP;

/**
 * Created by sqfan on 8/20/17.
 */
public class L_044_Wildcard_Matching {
  /**
   * 2D-DP
   * 时间：O(m*n)
   * 空间：O(m*n)
   */
  public boolean isMatch(String str, String pat) {
    char[] s = str.toCharArray();
    char[] p = pat.toCharArray();

    boolean[][] dp = new boolean[s.length + 1][p.length + 1];
    dp[0][0] = true;
    for (int j = 0; j < p.length; j++) {
      dp[0][j+1] = (p[j] == '*' && dp[0][j]);
    }

    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < p.length; j++) {
        if (p[j] != '*') {
          dp[i + 1][j + 1] = (p[j] == '?' || p[j] == s[i]) && dp[i][j];
        } else {
          dp[i + 1][j + 1] = dp[i+1][j] // ignore '*'
                          || dp[i][j+1]; // one or more match '*'
        }
      }
    }

    return dp[s.length][p.length];
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////

  /**
   * The basic idea is to have one pointer for the string and one pointer for the pattern.
   * This algorithm iterates at most length(string) + length(pattern) times, for each iteration,
   * at least one pointer advance one step.
   * 实际上是字符串的状态转移图的代码翻译：每次优先跳过'*'匹配pattern的下一个字符，若失配，则返回上次遇到'*"
   * 匹配成功的下一个位置继续匹配。
   */
  public boolean isMatch2(String str, String pat) {
    if (str.length() == 0 && pat.length() == 0) return true;
    if (pat.length() == 0) return false;

    char[] s = str.toCharArray();
    char[] p = pat.toCharArray();
    int i = 0, j = 0, m = -1, startIdx = -1;
    while (i < s.length) {
      if (j < p.length && (p[j] == '?' || p[j] == s[i])) {
        i++;
        j++;
      } else if (j < p.length && p[j] == '*') {
        startIdx = j;
        m = i;
        j++;
      } else if (startIdx != -1) {
        i = ++m;
        j = startIdx;
      } else {
        return false;
      }
    }
    while (j < p.length && p[j] == '*') j++;
    return j == p.length;
  }

  public static void main(String[] args) {
    L_044_Wildcard_Matching solution = new L_044_Wildcard_Matching();
    System.out.println(solution.isMatch("aa", "b*"));
    System.out.println(solution.isMatch2("aa", "*"));
  }
}
