package Leetcode.Array;

import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 * 找出数组中重复元素最多的元素.
 */
public class J_854_Most_Frequent_Num_In_Array {
  /**
   * 思路：使用一个Map对不同数出现次数进行计数。
   * 时间：O(N)
   * 空间：O(N)
   */
  public static int getMostFreqeentEle(int[] nums) {
    Map<Integer, Integer> freq = new HashMap<>();
    for (int num : nums) {
      if (freq.containsKey(num)) freq.put(num, freq.get(num) + 1);
      else freq.put(num, 1);
    }
    int value = 0, maxFreq = Integer.MIN_VALUE;
    for (Entry entry : freq.entrySet()) {
      if ((int) entry.getValue() > maxFreq) {
        maxFreq = (int) entry.getValue();
        value = (int) entry.getKey();
      }
    }
    return value;
  }
  public static void main(String[] args) {
    int[] nums = {1,1,2,2,4,4,4,5,6,6,7};
    System.out.println(getMostFreqeentEle(nums));
  }
}
