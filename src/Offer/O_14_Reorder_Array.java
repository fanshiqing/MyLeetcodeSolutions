package Offer;

/**
 * Created by sqfan on 8/4/17.
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class O_14_Reorder_Array {

  /**
   * 思路：类似冒泡算法，前偶后奇数就交换。
   * 时间：O(n*2),在偶数全在前，奇数全在后的情况，复杂度最坏(0.25*O(n^2),例如：[2，4，6，8，1，3,5,7]
   * 空间：O(1)
   */
  public void reOrderArray(int [] array) {
    for (int i = array.length - 1; i > 0; i--) {
      boolean reverse = false;

      for (int j = 0; j < i; j++) {
        if (((array[j] & 1) == 0) && ((array[j+1] & 1) == 1)) {
          int t = array[j];
          array[j] = array[j+1];
          array[j+1] = t;
          reverse = true;
        }
      }
      if (reverse == false) break;
    }
  }
  /**
   * In-place操作
   * 时间：O(n*n)
   * 空间：O(1)
   */
  public void reOrderArray2(int [] array) {
    for (int i = 0; i < array.length; i++) {
      if ((array[i] & 1) == 1) continue;
      int j = i;
      while (++j < array.length && (array[j] & 1) == 0)  ;
      if (j == array.length) break;
      int tmp = array[j];
      for (int k = j - 1; k >= i; k--) array[k+1] = array[k];
      array[i] = tmp;

    }
  }

  /**
   * 时间：O(n)
   * 空间：O(n)
   */
  public void reOrderArray3(int [] array) {
    int[] tmp = array.clone();
    int j = 0;
    for (int i = 0; i < tmp.length; i++) {
      if ((tmp[i] & 1) == 1) array[j++] = tmp[i]; // odd
    }
    for (int i = 0; i < tmp.length; i++) {
      if ((tmp[i] & 1) == 0) array[j++] = tmp[i]; // even
    }
  }
}
