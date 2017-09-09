package Leetcode.DP;

import java.util.HashMap;

/**
 * 数组中的最长连续序列. 要求时间复杂度为O(n)
 */
public class L_128_Longest_Consecutive_Sequence {
  /**
   * 思路：使用Hash表。
   *      - key：遍历过的某个数；
   *      - value：key这个数所在的最长连续序列的长度。
   * 时间：O(n)
   * 空间：O(n)
   */
  public static int longestConsecutive(int[] nums) {
    if (nums == null || nums.length == 0) return 0;

    HashMap<Integer, Integer> map = new HashMap<>();
    int maxConsecLen = 1;
    for (int num : nums) {
      if (!map.containsKey(num)) {
        map.put(num, 1);
        if (map.containsKey(num - 1)) {
          maxConsecLen = Math.max(merge(map, num-1, num), maxConsecLen);
        }
        if (map.containsKey(num + 1)) {
          maxConsecLen = Math.max(merge(map, num, num+1), maxConsecLen);
        }
      }
    }
    return maxConsecLen;
  }

  private static int merge(HashMap<Integer, Integer> map, int less, int more) {
    int len1 = map.get(less);
    int len2 = map.get(more);
    int mergeLen = len1 + len2;

    // 只需要在哈希表中更新合并后新区间的最左边界和最右边界，中间数值不会再用到
    map.put(less - len1 + 1, mergeLen);
    map.put(more + len2 - 1, mergeLen);

    return mergeLen;
  }

  public static void main(String[] args) {
    int[] nums = {100,3,2,300,1,5,6,7};
    System.out.println(longestConsecutive(nums));
  }
}
