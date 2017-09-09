package Leetcode.Array;

/**
 * 需要排序的最短子数组长度。
 */
public class L_581_Shortest_Unsorted_Continuous_Subarray {
  /**
   * clone()数组并排序，再首位向中间比较相同的元素位置。
   * 时间：O(nlog(n))
   * 空间：O(n)
   */
  public static int findUnsortedSubarray(int[] nums) {
    if (nums.length <= 1) return 0;
    int[] tmp = nums.clone();

    java.util.Arrays.sort(tmp);
    int i = 0, j = nums.length - 1;
    while (i < nums.length && tmp[i] == nums[i]) i++;
    while (j >= 0 && tmp[j] == nums[j]) j--;

    int len = j - i + 1;
    return len < 0 ? 0 : len;
  }

  /**
   * 依次从左向右、从右向左比较直到元素不在排序好的数组中应在在的位置为止。
   * 时间：最坏O(n^2)
   * 空间：O(1)
   */
  public static int findUnsortedSubarray2(int[] nums) {
    if (nums.length <= 1) return 0;
    int i = 0, j = nums.length - 1;
    for ( ; i < nums.length; i++) {
      int k = i + 1;
      for ( ; k < nums.length; k++) {
        if (nums[i] > nums[k]) {
          break;
        }
      }
      if (k != nums.length) break;
    }
    for ( ; j >= i; j--) {
      int k = j - 1;
      for ( ; k >= i; k--) {
        if (nums[j] < nums[k]) break;
      }
      if (k != i - 1) break;
    }
    return j - i + 1;
  }

  public static void main(String[] args) {
    int[] nums = {2, 1};
    int[] nums2 = {2,2,3,9};
    int[] nums3 = {2,6,4,8,10,9,15};

    System.out.println(findUnsortedSubarray(nums));
    System.out.println(findUnsortedSubarray2(nums));
    System.out.println(findUnsortedSubarray(nums2));
    System.out.println(findUnsortedSubarray2(nums2));
    System.out.println(findUnsortedSubarray(nums3));
    System.out.println(findUnsortedSubarray2(nums3));
  }
}
