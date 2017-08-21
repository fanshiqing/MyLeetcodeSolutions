package Leetcode.DP;

import java.util.Arrays;

/**
 * 最长递增子序列的长度。
 */
public class L_300_Longest_Increasing_Subsequence {
  /**
   * 时间：O(n^2)
   * 空间：O(n)
   */
  public static int lengthOfLIS(int[] nums) {
    if (nums.length == 1) return 1;
    if (nums.length == 0) return 0;
    // dp[i]表示nums[0..i]中的最大递增子序列长度
    int[] dp = new int[nums.length];
    dp[0] = 1;
    int maxSeq = 0;
    for (int i = 1; i < nums.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) { // 注意是纯"递增"序列！！！
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxSeq = Math.max(maxSeq, dp[i]);
    }
    return maxSeq;
  }

  ////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 时间为O(nlog(n))的解法
   * tails is an array storing the smallest tail of all increasing subsequences
   * with length i+1 in tails[i]. For example, say we have nums = [4,5,6,3], then
   * all the available increasing subsequences are:
   *  len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
   *  len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
   *  len = 3   :      [4, 5, 6]            => tails[2] = 6
   */
  public int lengthOfLIS2(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    for (int x : nums) {
      int i = 0, j = size;
      while (i != j) {
        int m = (i + j) / 2;
        if (tails[m] < x)
          i = m + 1;
        else
          j = m;
      }
      tails[i] = x;
      if (i == size) ++size;
    }
    return size;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,6,7,9,4,10,5,6};
    System.out.println(lengthOfLIS(nums));
//    Arrays.binarySearch()
  }
}
