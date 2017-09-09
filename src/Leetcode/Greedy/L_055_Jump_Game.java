package Leetcode.Greedy;

/**
 * 跳跃游戏I.
 */
public class L_055_Jump_Game {
  // Time Limit Exception
  public boolean canJump(int[] nums) {
    boolean[] reachable = new boolean[nums.length];
    reachable[0] = true;
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 1; j <= nums[i]; j++) {
        if (reachable[i] == true && i + j < nums.length) reachable[i+j] = true;
      }
    }
    return reachable[nums.length - 1];
  }

  /**
   * 贪心解法。自顶向下。
   */
  public static boolean canJump2(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      if (i > max) return false;
      max = Math.max(max, i + nums[i]);
      if (max >= nums.length - 1) break;
    }
    return max >= nums.length - 1;
  }

  /**
   * 贪心解法。自底向上。
   * 时间：O(n)
   * 空间：O(1)
   */
  public static boolean canJump3(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 2; i >= 0; i--) {
      if (i + nums[i] >= lastPos) {
        lastPos = i;
      }
    }
    return lastPos == 0;
  }

  public static void main(String[] args) {
//    int[] nums = {2,3,1,1,4};
    int[] nums2 = {3,2,1,0,4};
//    System.out.println(canJump2(nums));
    System.out.println(canJump2(nums2));
  }
}
