package Offer;

/**
 * Created by sqfan on 8/3/17.
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 *    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class O_08_Min_Number_In_Rotate_Array {

  /**
   * 最直接的解法,但没有利用旋转数组的特性。
   * 时间：O(n)
   * 空间：O(1)
   */
  public int minNumberInRotateArray2(int [] array) {
    if (array.length == 0) return 0;
    int min = array[0];
    for (int i = 1; i < array.length; i ++) {
      if (array[i] < min) {
        min = array[i];
        break;
      }
    }
    return min;
  }

  /**
   * 充分利用输入序列的2段有序性，进行二分搜索。
   * 时间：O(logn)
   * 空间：O(1)
   */
  public int minNumberInRotateArray(int [] array) {
    if (array.length == 0) return 0;
    else return helper(array, 0, array.length - 1);
  }

  public int helper(int[] array, int left, int right) {
    if (left + 1 >= right) return Math.min(array[left], array[right]);

    int mid = (left + right) / 2;
    int min = array[left];
    // !!! left, mid, right三值相等，不能判断向左二分还是向右二分
    if (array[left] == array[right] && array[left] == array[mid]) {
      for (int i = left; i <= right; i++) {
        if (array[i] < min) {
          min = array[i];
          break;
        }
      }
    }
    else if (array[mid] >= array[left]) return helper(array, mid, right);
    else if (array[mid] <= array[right]) return helper(array, left, mid);
    return min;
  }


  public static void main(String[] args) {
    O_08_Min_Number_In_Rotate_Array solution = new O_08_Min_Number_In_Rotate_Array();
    int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,
        9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,
        4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
//    int[] array = {1,1,1,1,1,0,1};
//    int[] array = {1};
//    int[] array = {3,4,5,6,1,2,3};
    System.out.println(solution.minNumberInRotateArray(array));
  }
}
