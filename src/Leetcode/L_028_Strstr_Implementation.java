package Leetcode;

/**
 * Created by sqfan on 8/7/17.
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack,
 *    or -1 if needle is not part of haystack.
 */
public class L_028_Strstr_Implementation {

  /**
   * KMP算法。避免Brute-force解法中的回溯。
   * 时间：O(n)
   * 空间：O(pat.length)
   */
  public static int strStr(String haystack, String needle) {
    int i= 0, j = 0;
    if (needle.length() == 0) return 0; // !!! pattern is empty string !!!
    int[] next = getNext(needle);
    while (i < haystack.length() && j < needle.length()) {
      if (j == -1 || haystack.charAt(i) == needle.charAt(j)) { // 对应字符串匹配
        i ++;
        j ++;
      } else {
        j = next[j];
      }
    }
    if (j < needle.length()) return -1;
    return i - j;
  }

  /**
   * 这个查找过程本质上也是一个模式匹配过程（只是目标串和模式串是同一个）
   */
  private static int[] getNext(String pat) {
    int[] next = new int[pat.length()];
    int i = -1, j = 0;
    next[0] = -1;
    while (j < pat.length() - 1) {
      if (i == -1 || pat.charAt(i) == pat.charAt(j)) {
        i ++;
        j ++;
        next[j] = i;
      } else {
        i = next[i];
      }
    }

    return next;
  }
  /**
   * Brute-force.因为带回溯，速度慢。
   * 时间：O(n^2)
   * 空间：O(1)
   */
  public int strStr2(String haystack, String needle) {
    for (int i = 0; i <= haystack.length() - needle.length(); i++) {
      int j = 0;
      while (j < needle.length() && haystack.charAt(i + j) == needle.charAt(j)) j++;
      if (j == needle.length()) return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    String s = "nanjing";
    String pat = "ing";

    System.out.println(strStr(s, pat));
  }
}
