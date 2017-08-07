package Offer;

import java.util.HashMap;
/**
 * Created by sqfan on 8/7/17.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *    例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 *    如果不存在则输出0。
 *
 * 注意： HashMap的map.getOrDefault在jdk1.8开始才有支持
 */
public class O_29_More_Than_Half_Number_in_List {

  public static int MoreThanHalfNum_Solution(int [] array) {
    if (array.length == 0) return 0;
    int count = 1;
    int major = array[0];
    for (int i = 1; i < array.length; i++) {
      if (count == 0) {
        major = array[i];
        count ++;
      } else if (major == array[i]) count ++;
      else count --;
    }

    // Verify whether the major is the REAL majority
    count = 0;
    for (int a : array) {
      if (major == a) count ++;
    }
    if (2 * count > array.length) return major;
    return 0; // not found
  }
  /**
   * 单趟扫描数组，使用map记录每个value的频次。
   * 时间：O(n)
   * 空间：O(n)
   */
  public static int MoreThanHalfNum_Solution2(int [] array) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < array.length; i++) {
      if (map.containsKey(array[i])) map.put(array[i], map.get(array[i]) + 1);
      else map.put(array[i], 1);
      if (map.get(array[i]) * 2 > array.length) return array[i];
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,2,2,2,5,4};
//    int[] array = {1,2,3,2,2,2,5,4,2};
    int ans = MoreThanHalfNum_Solution2(array);
    System.out.println(ans);
  }
}
