package Leetcode.Array;

/**
 * 找出无序数组中第二大的数。
 */
public class J_852_Second_Largest_Num_In_Array {

  /**
   * 一遍扫描，并更新两个临时变量max和次max
   * 时间：O(n)
   */
  public static int getSecondLargest(int[] array) {
    if (array.length <= 1) {
      throw new IllegalArgumentException("Illegal Argument");
    }
    int max = array[0];
    int secMax = Integer.MIN_VALUE;
    for (int i = 1; i < array.length; i++) {
      if (array[i] > max) {
        secMax = max;
        max = array[i];
      } else if (array[i] > secMax){
        secMax = array[i];
      }
    }
    return secMax;
  }

  public static void main(String[] args) {
    int[] array = {12,3,4,1,23,4,3,8,9,22};
    System.out.println(getSecondLargest(array));
  }
}
