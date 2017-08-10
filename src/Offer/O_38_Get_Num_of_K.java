package Offer;

/**
 * Created by sqfan on 8/10/17.
 * 统计一个数字在排序数组中出现的次数。
 */
public class O_38_Get_Num_of_K {
  /**
   * 二分查找，找到其中一个k后，分别向左、向右扫描得到k的计数。
   * 不足：若k值的序列很长，就比较低效（逼近O(n)）
   * 时间：O(logn)
   */
  public int GetNumberOfK(int [] array , int k) {
    int l = 0, r = array.length - 1, m = 0;
    int cnt = 0;
    while (l <= r) {
      m = (l + r) >> 1;
      if (array[m] == k) break;
      if (array[m] < k) {
        l = m + 1;
      } else {
        r = m - 1;
      }
    }
    if (l <= r) {
      int t = m;
      while (t >= 0 && array[t--] == k) cnt ++;
      while (++m < array.length && array[m] == k) cnt ++;
    }
    return cnt;
  }

  /**
   * 解法2：对解法1的改进：用二分法找出k序列的头和尾
   * 时间：O(log(n))
   */
  public int GetNumberOfK2(int [] array , int k) {
    int l = getFirst(array, k, 0, array.length - 1);
    int r = getLast(array, k, 0, array.length - 1);
    if (l != -1) return r - l + 1;
    return 0;
  }
  private int getFirst(int[] array, int k, int l, int r) {
    if (l <= r && array[l] == k) return l;
    while (l <= r) {
      int m = (l + r) >> 1;
      if (array[m] < k) l = m + 1;
      else if (array[m] > k) r = m - 1;
      else { // array[m] == k
        if (array[m - 1] != k) return m;
        else r = m - 1;
      }
    }
    return -1;
  }
  private int getLast(int[] array, int k, int l, int r) {
    if (l <= r && array[r] == k) return r;
    while (l <= r) {
      int m = (l + r) >> 1;
      if (array[m] < k) l = m + 1;
      else if (array[m] > k) r = m - 1;
      else { // array[m] == k
        if (array[m + 1] != k) return m;
        else l = m + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    O_38_Get_Num_of_K solution = new O_38_Get_Num_of_K();
    int[] nums = {1,2,3,4,4,4,4,4,4,4,5};
    assert(solution.GetNumberOfK2(nums, 4) == 7);
  }
}
