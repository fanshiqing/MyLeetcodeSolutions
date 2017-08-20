package Leetcode.DP;

import java.util.Stack;

/**
 * Created by sqfan on 8/20/17.
 */
public class L_032_Longest_Valid_Parentheses {
  /**
   * Solution 2: DP
   * Time: O(n)
   * Space: O(n)
   */
  public int longestValidParentheses2(String s) {
    int[] dp = new int[s.length()];
    int maxLen = 0;
    for (int i = 1; i < s.length(); i++) {
       if (s.charAt(i) == ')') {
         if (s.charAt(i - 1) == '(') {
           dp[i] = (i-2 >= 0 ? dp[i-2] : 0 ) + 2;
         } else if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
           dp[i] = dp[i-1] + ((i - dp[i-1] - 2) >= 0 ? dp[i - dp[i-1] - 2] : 0) + 2;
         }
         maxLen = Math.max(dp[i], maxLen);
       }
    }
    return maxLen;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 解法4: 不使用额外空间的解法，分别left2right和right2left两趟扫描字符串
   * Time: O(2*n)
   * Space: O(1)
   */
  public int longestValidParentheses4(String s) {
    int maxLen = 0;
    int lc = 0, rc = 0; // left count, right count;
    for (int i = 0; i < s.length(); i++) { // left to right
      if (s.charAt(i) == '(') lc++;
      else rc++;
      if (lc == rc) maxLen = Math.max(maxLen, 2 * lc);
      else if (lc < rc) {
        lc = 0;
        rc = 0;
      }
    }
    lc = 0;
    rc = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ')') rc++;
      else lc++;
      if (lc == rc) maxLen = Math.max(maxLen, 2 * lc);
      else if (lc > rc) {
        lc = 0;
        rc = 0;
      }
    }
    return maxLen;
  }
  //////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 解法3：使用Stack
   * Time: O(n)
   * Space: O(n)
   */
  public int longestValidParentheses3(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        stack.pop();
        if (stack.isEmpty()) {
          stack.push(i);
        } else {
          maxLen = Math.max(maxLen, i - stack.peek());
        }
      }
    }
    return maxLen;
  }


  //////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * Solution 1: Brute Force
   * Time: O(n^3)
   * Space: O(n)
   */
  public int longestValidParentheses1(String s) {
    int maxLen = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = i + 2; j <= s.length(); j++) {
        if (isValid(s.substring(i, j))) {
          maxLen = Math.max(maxLen, j - i);
        }
      }
    }
    return maxLen;
  }

  /**
   * Check whether string is valid parentheses.
   */
  private boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push('(');
      } else if (s.charAt(i) == ')' && !stack.isEmpty()) {
        stack.pop();
      } else {
        return false;
      }
    }
    return stack.isEmpty();
  }

  public static void main(String[] args) {
    String s = "(((()))))()";
    L_032_Longest_Valid_Parentheses solution = new L_032_Longest_Valid_Parentheses();
    System.out.println(solution.longestValidParentheses1(s));
    System.out.println(solution.longestValidParentheses2(s));
    System.out.println(solution.longestValidParentheses3(s));
    System.out.println(solution.longestValidParentheses4(s));
  }
}
