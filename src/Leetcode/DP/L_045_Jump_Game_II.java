package Leetcode.DP;

/**
 * 跳跃游戏：从index=0调到数组末尾，求最少跳跃步数
 */
public class L_045_Jump_Game_II {
  /**
   * ------> TLE.
   * @param nums
   * @return
   */
  public int jump(int[] nums) {
    int[] dp = new int[nums.length];
    dp[0] = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 1; j <= nums[i] && i + j <= nums.length - 1; j++) {
        dp[i + j] = dp[i + j] == 0 ? (dp[i] + 1) : Math.min(dp[i + j], dp[i] + 1);
      }
    }
    return dp[nums.length - 1];
  }

  /**
   * 时间：O(n)
   * 空间：O(1）
   */
  public static int jump2(int[] nums) {
    if (nums == null || nums.length == 1) return 0;

    int jump = 0;  // 目前跳了多少步
    int cur = 0;   // 只跳jump步能到达的最远距离
    int next = 0;  // 再多跳一步能到达的最远距离
    for (int i = 0; i < nums.length; i++) {
      if (cur < i) {
        jump ++;
        cur = next;
      }
      next = Math.max(next, i + nums[i]);
    }
    return jump;
  }

  public static void main(String[] args) {
    int[] nums = {5,9,3,2,1,0,2,3,3,1,0,0};
    System.out.println(jump2(nums));
  }
}
