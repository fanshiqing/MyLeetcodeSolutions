package Leetcode.Binary_Search;

/**
 * [L-033-follow-up] 旋转有序数组（有重）的搜索问题
 */
public class L_081_Search_in_Rotated_Sorted_Array_II {
  /**
   * 平均时间：O(log(N)), 最坏时间：O(N)
   */
  public static boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return false;
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) return true;
      if (nums[mid] == nums[right] || nums[mid] == nums[left]) { // 不能二分
        for (int i = left; i <= right; i++) {
          if (target == nums[i]) return true;
        }
        return false;
      } else if (nums[mid] > nums[right]) {
        if (target > nums[mid] || target < nums[left]) left = mid + 1;
        else right = mid - 1;
      } else { // nums[mid] < nums[right]
        if (target < nums[mid] || target > nums[right]) right = mid - 1;
        else left = mid + 1;
      }
    }
    return nums[left] == target;
  }

  public static void main(String[] args) {
    System.out.println(search(new int[] {}, 3)); // false
    System.out.println(search(new int[] {1,2,4,5,6}, 3)); // false
    System.out.println(search(new int[] {3,3,3,1,2,3}, 3)); // true
  }
}
