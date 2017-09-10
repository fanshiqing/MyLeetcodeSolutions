package Leetcode.Binary_Search;

/**
 * Created by sqfan on 8/11/17.
 * 找出两个有序数组的中位数,要求时间复杂度为O(log(m + n))
 */
public class L_004_Median_of_Two_Sorted_Arrays {

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;

    double median = getKth(nums1, 0, nums2, 0, (l1+l2)/2)
        + getKth(nums1, 0, nums2, 0, (l1+l2-1)/2);

    return median/2;
  }

  /**
   * 两个有序数组，求第k(从0计数）个数。
   * 时间：O(log(m+n))
   * @param nums1 sorted array 1
   * @param s1 start search index of array1
   * @param nums2 sorted array 2
   * @param s2 start search index of array2
   * @param k indexed from 0.
   * @return the kth element of these two sorted array
   */
  public double getKth(int[] nums1, int s1, int[] nums2, int s2, int k) {
    if (s1 >= nums1.length) return nums2[s2 + k];
    if (s2 >= nums2.length) return nums1[s1 + k];
    if (k == 0) return Math.min(nums1[s1], nums2[s2]);

    // 当nums1[l1...r1]和nums2[l2...r2]不足k/2偏移时，下面的处理很巧妙:
    // 较长的数组扔掉（k+1)/2 个数不会影响最终的第k个值。
    int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
    if (s1 + k/2 < nums1.length) aMid = nums1[s1 + k/2];
    if (s2 + k/2 < nums2.length) bMid = nums2[s2 + k/2];

    if (aMid < bMid) { // aRight+bLeft
      return getKth(nums1, s1 + (k+1)/2, nums2, s2,k - (k+1)/2);
    } else { // aLeft+aRight
      return getKth(nums1, s1, nums2, s2 + (k+1)/2, k - (k+1)/2);
    }
  }
  public static void main(String[] args) {
    int[] nums1 = {1,2};
    int[] nums2 = {};
//    int[] nums1 = {1, 2};
//    int[] nums2 = {3, 4, 5};
    L_004_Median_of_Two_Sorted_Arrays solution = new L_004_Median_of_Two_Sorted_Arrays();
    double result = solution.findMedianSortedArrays(nums1, nums2);
    System.out.println(result);
  }

}
