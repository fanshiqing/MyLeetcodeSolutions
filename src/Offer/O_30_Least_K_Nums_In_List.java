package Offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sqfan on 8/7/17.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4.
 */
public class O_30_Least_K_Nums_In_List {
  /**
   * 思路：借助Partition操作循环划分出前k个元素；
   * 时间：O(n)
   * 空间：O(1)(修改原有输入数组)
   * @return
   */
  public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
    ArrayList<Integer> result = new ArrayList<>();
    if (k <= 0 || k > input.length) return result;
    if (k == input.length) {
      for (int a : input) result.add(a);
      return result;
    }
    int split = Partition(input, 0, input.length - 1);
    while (true) {
      if (split == k - 1) break;
      if (split > k - 1) split = Partition(input, 0, split - 1);
      else split = Partition(input, split + 1, input.length - 1);
    }

    for (int i = 0; i < k; i++) result.add(input[i]);
    return result;
  }

  /**
   * Partition Operation.
   */
  private static int Partition(int[] array, int left, int right) {
    int pivot = array[left];
    int split = left;
    for (int i = left + 1; i <= right; i++) {
      if (array[i] < pivot) {
        split ++;
        if (split != i) {
          int tmp = array[split];
          array[split] = array[i];
          array[i] = tmp;
        }
      }
    }
    array[left] = array[split];
    array[split] = pivot;

    return split;
  }

  public static void main(String[] args) {
    int[] array = {4,0,1,6,2,7,3,1};
//    int[] array = {4,5,1,6,2,7,3,8};
    int k = 8;
    ArrayList<Integer> result = GetLeastNumbers_Solution(array, k);
    System.out.println(result);
  }
}
