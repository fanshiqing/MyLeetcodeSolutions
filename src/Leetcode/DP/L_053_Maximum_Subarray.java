package Leetcode.DP;

/**
 * 最大子数组之和
 *  1. DP： maxSubArray(A, i) = maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i];
 *  2. Divide-and-Conquer
 *    1) Divide the given array in two halves
      2) Return the maximum of following three
          a) Maximum subarray sum in left half (Make a recursive call)
          b) Maximum subarray sum in right half (Make a recursive call)
          c) Maximum subarray sum such that the subarray crosses the midpoint
 */
public class L_053_Maximum_Subarray {
  /**
   * DP solution.
   * 时间：O(n)
   */
  public static int maxSubArray(int[] nums) {
    if (nums.length == 0) throw new IllegalArgumentException();
    int maxSum = nums[0];
    int curSum = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (curSum < 0) curSum = 0;
      curSum += nums[i];
      maxSum = Math.max(maxSum, curSum);
    }
    return maxSum;
  }

  /**
   * Divide and Conquer Solution.
   *  Step1. 选择数组的中间位置的元素nums[mid], 则 和最大的子数组 要么①不包含nums[mid];② 包含nums[mid]
   *    Step2.1 不包含nums[mid]: 则递归处理nums[mid]的left part 和 right part
   *    Step2.2 包含nums[mid]: 那结果就是left part的最大子数组之和 + right part的最大子数组之和
   *  Step3. 返回 max {上述三种case}
   */
  public static int maxSubArray2(int[] nums) {
    return helper(nums, 0, nums.length - 1);
  }

  private static int helper(int[] nums, int left, int right) {
    if (left == right) return nums[left];
    int mid = (left + right) / 2;
    // Step 2.1
    int leftMax = helper(nums, left, mid);
    int rightMax = helper(nums, mid + 1, right);

    // Step 2.2
    int lmax = Integer.MIN_VALUE;
    int sum = 0;
    for (int i = mid; i >= 0; i--) {
      sum += nums[i];
      if (sum > lmax) lmax = sum;
    }

    int rmax = Integer.MIN_VALUE;
    sum = 0;
    for (int i = mid + 1; i <= right; i++) {
      sum += nums[i];
      rmax = Math.max(rmax, sum);
    }

    return Math.max(Math.max(leftMax, rightMax), lmax + rmax);
  }

  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(maxSubArray(nums));
    System.out.println(maxSubArray2(nums));
  }
}
