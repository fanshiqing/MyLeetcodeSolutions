package Offer;

/**
 * Created by sqfan on 8/10/17.
 * Modified Merge Sort.
 */
public class O_36_Inverse_Pairs {
  private int[] array;
  private int[] helper;

  public int InversePairs(int [] array) {
    this.array = array;
    helper = new int[array.length];
    int count = MergeSort(0, array.length - 1);
    return count;
  }
  private int MergeSort(int begin, int end) {
    if (begin < end) {
      int m = (begin + end) >> 1;
      int lc = MergeSort(begin, m); // left count
      int rc = MergeSort(m + 1, end); // right count
      int cnt = Merge(begin, m, end);
      return cnt + lc + rc;
    }
    return 0;
  }
  private int Merge(int begin, int m, int end) {
    for (int i = begin; i <= end; i++) helper[i] = array[i];
    int i1 = m, i2 = end, i = end, cnt = 0;
    while (i1 >= begin && i2 >= m + 1) {
      if (helper[i1] < helper[i2]) array[i--] = helper[i2--];
      else {
        array[i--] = helper[i1--];
        cnt += i2 - m;
      }
    }
    while (i1 >= begin) {
      array[i--] = helper[i1--];
    }
    while (i2 >= m + 1) array[i--] = helper[i2--];
    return cnt;
  }

  public static void main(String[] args) {
    O_36_Inverse_Pairs solution = new O_36_Inverse_Pairs();
    int[] array = {5,3,2,1,4};
    int cnt = solution.InversePairs(array);
    System.out.println(cnt);
  }
}
