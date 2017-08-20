package Leetcode.DP;

/**
 * Created by sqfan on 8/18/17.
 */
public class L_010_Regular_Expression_Matching {
  /**
   * Solution2: DP解法(2D-DP):
   * if[i][j]: if s[0..i-1] matches p[0..j-1]
   * if p[j - 1] != '*'
   *      f[i][j] = f[i - 1][j - 1] && s[i - 1] == p[j - 1]
   * if p[j - 1] == '*', denote p[j - 2] with x
   *      f[i][j] is true iff any of the following is true
   *      1) "x*" repeats 0 time and matches empty: f[i][j - 2]
   *      2) "x*" repeats >= 1 times and matches "x*x": s[i - 1] == x && f[i - 1][j]
   * '.' matches any single character
   */
  public boolean isMatch_DP(String str, String pat) {
    boolean[][] dp = new boolean[str.length() + 1][pat.length() + 1];
    dp[0][0] = true;
    char[] s = str.toCharArray();
    char[] p = pat.toCharArray();
    for (int j = 0; j < p.length; j++) {
      dp[0][j+1] = (p[j] == '*' && dp[0][j-1]);
    }
    for (int i = 0; i < s.length; i++) {
      for (int j = 0; j < p.length; j++) {
        if (p[j] != '*') {
          dp[i+1][j+1] = (p[j] == '.' || p[j] == s[i]) && dp[i][j];
        } else {
          dp[i+1][j+1] = dp[i+1][j-1] || (p[j-1] == '.' || p[j-1] == s[i] ? dp[i][j+1] : false);
        }
      }
    }
    return dp[s.length][p.length];
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * Solution1: 递归解法
   * 时间：O(n^2) (有回溯)
   * 空间：O(1)
   */
  public boolean isMatch(String s, String p) {
    return matchCore(s.toCharArray(), 0, p.toCharArray(), 0);
  }

  public boolean matchCore(char[] s, int i, char[] p, int j) {
    if (i == s.length && j == p.length) return true;
    if (j == p.length && i < s.length) return false;
    if (i == s.length && j < p.length) {
      while (j+1 < p.length && p[j+1] == '*') j += 2;
      return j == p.length;
    }

    if (j+1 < p.length && p[j+1] == '*') {
      if (p[j] == '.' || p[j] == s[i]) return matchCore(s, i+1, p, j) || matchCore(s, i, p, j+2);
      else return matchCore(s, i, p, j+2);
    } else if (p[j] == '.' || p[j] == s[i]) return matchCore(s, i+1, p, j+1);
    else return false;
  }
  public static void main(String[] args) {
    String s1 = "nanjing";
    System.out.println("".matches(""));
    System.out.println("".matches(".*"));
    L_010_Regular_Expression_Matching solution = new L_010_Regular_Expression_Matching();
    System.out.println(solution.isMatch("a", "*"));
  }
}
