package Leetcode;

/**
 * Created by sqfan on 8/18/17.
 */
public class L_010_Regular_Expression_Matching {
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
  }
}
