/**
 * Created by sqfan on 8/10/17.
 * MergeSort Algorithm.
 */
public class MergeSort {
  private int[] values;
  private int[] helper;

  public void sort(int[] array) {
    this.values = array;
    helper = new int[array.length];
    MergeSort(0, array.length - 1);
  }

  /**
   * Time: O(nlogn)
   * Space: O(n)
   */
  private void MergeSort(int l, int r) {
    if (l < r) {
      int m = (l + r) >> 1;
      MergeSort(l, m);
      MergeSort(m + 1, r);
      Merge(l, m, r);
    }
  }

  private void Merge(int l, int m, int r) {
    for (int i = l; i <= r; i++) helper[i] = values[i];
    int i1 = l, i2 = m + 1, i = l;
    while (i1 <= m && i2 <= r) {
      if (helper[i1] <= helper[i2]) values[i++] = helper[i1++];
      else values[i++] = helper[i2++];
    }
    while (i1 <= m) values[i++] = helper[i1++];
    while (i2 <= r) values[i++] = helper[i2++];
  }

  public static void main(String[] args) {
    MergeSort mSort = new MergeSort();
    int[] array = {4,3,54,2,1,9,24};
    mSort.sort(array);
    for (int a : array) System.out.print(a + ", ");
  }
}
