package Leetcode;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by sqfan on 8/11/17.
 */
public class L_347_Top_K_Frequent_Elements {
  public List<Integer> topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> map = new HashMap<>();
    ArrayList<Integer> result = new ArrayList<>();
    for (int a : nums) {
      if (map.containsKey(a)) map.put(a, map.get(a) + 1);
      else map.put(a, 1);
    }
    List<Integer>[] bucket = new List[nums.length + 1];
    for (Integer key : map.keySet()) {
      int freq = map.get(key);
      if (bucket[freq] == null) {
        bucket[freq] = new ArrayList<>();
      }
      bucket[freq].add(key);
    }
    for (int i = nums.length; i >= 0 && k > 0; i--) {
      if (bucket[i] != null) {
        for (Integer a : bucket[i]) {
          result.add(a);
          k --;
          if (k == 0) break;
        }
      }
    }
    return result;
  }
  public static void main(String[] args) {
    L_347_Top_K_Frequent_Elements solution = new L_347_Top_K_Frequent_Elements();
    int[] nums = {1,1,1,2,2,2,3,3,3,4,1,5};
    List result = solution.topKFrequent(nums, 2);
    System.out.println(result);
  }
}
