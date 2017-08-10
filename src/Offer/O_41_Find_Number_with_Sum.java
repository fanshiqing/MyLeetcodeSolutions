package Offer;

import java.util.ArrayList;

/**
 * Created by sqfan on 8/10/17.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S,
 * 输出两个数的乘积最小的。对应每个测试案例，输出两个数，小的先输出.
 * 时间：O(n)
 * 空间：O(1)
 */
public class O_41_Find_Number_with_Sum {
  public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
    int l = 0, r = array.length - 1;
    ArrayList<Integer> result = new ArrayList<>();
    while (l < r) {
      if (array[l] > sum) break;
      if (array[l] + array[r] < sum) l++;
      else if (array[l] + array[r] == sum) {
        result.add(array[l]);
        result.add(array[r]);
        break;
      } else {
        r --;
      }
    }
    return result;
  }
}
