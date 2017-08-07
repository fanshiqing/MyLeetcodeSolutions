package Leetcode;

/**
 * Created by sqfan on 8/7/17.
 */
public class L_027_Remove_Element {
  /**
   * 思路：2个指针，一个从尾巴开始扫描，一个从头部开始扫描。
   *      性能最优。
   * 时间：O(n)
   * 空间：O(1)
   */
  public int removeElement(int[] nums, int val) {
    int i = 0, j = nums.length - 1;
    while (i <= j) {
      while (j >= i && nums[j] == val) j--;
      while (i <= j && nums[i] != val) i++;
      if (i < j) {
        nums[i] = nums[j];
        i++;
        j--;
      }
    }
    return (j < 0) ? 0 : (j + 1);
  }
}
