package Offer;

/**
 * Created by sqfan on 8/8/17.
 */
public class O_31_Greatest_Sum_Of_Sub_Array {
  public int FindGreatestSumOfSubArray(int[] array) {
    if (array.length == 0) return 0;
    int sum = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      if (sum < 0) sum = 0;
      sum += array[i];
      if (sum > max) max = sum;
    }

    return max;

  }
}
