package Leetcode;


import java.util.HashMap;

/**
 * Created by sqfan on 8/5/17.
 */
public class L_001_Two_Sum {

  /**
   * 思路：2轮Hash表，先建表，后查询
   * 时间: O(n)
   * 空间: O(n)
   */
  public static int[] twoSum(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) map.put(target - nums[i], i);
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
        return new int[] {i, map.get(nums[i])};
      }
    }
    throw new IllegalArgumentException("No such two numbers");
  }

  // 一轮hash表，边建边查
  public static int[] twoSum2(int[] nums, int target) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int t = target - nums[i];
      if (map.containsKey(t)) {
        return new int[] {map.get(t), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No such tow numbers");
  }

  public static void main(String[] args) {
    int[] nums = {3,2,4};
//    int[] nums = {2,7,11,15};
    int target = 6;
    int[] result = L_001_Two_Sum.twoSum2(nums, target);
    System.out.println(result[0] + ", " + result[1]);
  }
}
