package Leetcode.Binary_Search;

/**
 * 旋转有序数组（无重复）中的搜索.
 */
public class L_033_Search_In_Rotated_Sort_Array {
  /**
   * 二分查找。
   * 时间：O(log(n))
   */
  public static int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) return -1;

    int left = 0, right = nums.length - 1;
    while (left < right) {
      int mid = (left + right)/2;
      if (nums[mid] == target) return mid;

      if (nums[mid] > nums[right]) {
        if (target > nums[mid] || target < nums[left]) left = mid + 1;
        else if (target >= nums[left]) right = mid - 1;
      } else {
        if (target < nums[mid] || target > nums[right]) right = mid - 1;
        else left = mid + 1;
      }
    }
    return nums[left] == target ? left : -1;
  }

  public static void main(String[] args) {
//    System.out.println(search(new int[] {}, 1)); // -1
//    System.out.println(search(new int[] {2}, 1)); // -1
//    System.out.println(search(new int[] {1}, 1)); // 0
    System.out.println(search(new int[] {1, 3}, 3)); // 1
//    System.out.println(search(new int[] {1,2,3}, 1)); // 0
//    System.out.println(search(new int[] {2,3,1}, 1)); // 2
//    System.out.println(search(new int[] {2,3,4,5,6,7,1}, 1)); // 6
//    System.out.println(search(new int[] {2,4,5,6,7,1}, 3)); // -1

  }
}
