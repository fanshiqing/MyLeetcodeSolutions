package Leetcode.Binary_Search;

/**
 * 旋转数组中的最小值.
 */
public class L_153_Find_Minimum_in_Rotated_Sorted_Array {
  /**
   * 数组中有没重复的数字的情况：二分搜索
   * 时间：O(log(n))
   */
  public static int findMin(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }

  /**
   * 如果数组中有重复数字的情况
   * 时间：最坏：O(n)
   */
  public static int findMin2(int[] nums) {
    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right) / 2;
      // 这种情况下不能进行二分,最小值可能在左边，也可能在右边，只能暴力线性搜索
      if (nums[mid] == nums[right] || nums[mid] == nums[left]) {
        int min = nums[left];
        for (int i = left + 1; i <= right; i++) {
          min = Math.min(min, nums[i]);
        }
        return min;
      } else if (nums[mid] > nums[right]) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left];
  }
  public static void main(String[] args) {
//    int[] nums = {3,1,2};
//    System.out.println(findMin(new int[] {3,1,2}));
//    System.out.println(findMin(new int[] {1}));
//    System.out.println(findMin(new int[] {2,1}));
//    System.out.println(findMin(new int[] {3,4,1,2}));
//    System.out.println(findMin(new int[] {1,2,3,4,5,6}));
//    System.out.println(findMin(new int[] {6,5,4,3,2,1}));
//
//    // 可重复的情况
    System.out.println(findMin2(new int[] {1,2,3,4, 4, 4,4,4,4})); // mid=right && 最小值在pivot左边
    System.out.println(findMin2(new int[] {4,4,4,4, 4, 4,1,2,3})); // mid=left  && 最小值在pivot右边
    System.out.println(findMin2(new int[] {4,4,4,4, 4, 4,1,3,4})); // left=mid=right
    System.out.println(findMin2(new int[] {1,0,1,1,1})); // left=mid=right
    System.out.println(findMin2(new int[] {1,1,1,0,1})); // left=mid=right
  }
}
