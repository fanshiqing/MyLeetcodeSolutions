package Leetcode.Array;

/**
 * Created by sqfan on 8/11/17.
 */
public class L_215_Kth_Largest_Element_in_an_Array {
////////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 解法1：借助QuickSort中的Partition
   * 平均时间：O(n)
   * 最坏时间：O(n^2)
   */
  public int findKthLargest(int[] nums, int k) {
    if (k > nums.length || nums.length == 0) return 0;
    return getKth(nums, 0, nums.length - 1, nums.length - k);
  }

  public int getKth(int[] nums, int l, int r, int k) {
    int pivot = nums[l];
    int split = l;
    for (int i = l + 1; i <= r; i++) {
      if (nums[i] < pivot) {
        split ++;
        if (i != split) swap(nums, i, split);
      }
    }
    swap(nums, l, split);
    if (split == k) return nums[split];
    else if (split < k) return getKth(nums, split + 1, r, k);
    else return getKth(nums, l, split - 1, k);
  }
  public void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

////////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 解法2：全排序
   * 时间：O(nlogn)
   * 空间：O(1)
   */
  public int findKthLargest2(int[] nums, int k) {
    java.util.Arrays.sort(nums);
    return nums[nums.length - k];
  }

  //////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * 解法3： 优先级队列(MinHeap),只维护一个size为k的优先级队列。
   * 时间：O(Nlog(K))
   * 空间：O(K)
   */
  public int findKthLargest3(int[] nums, int k) {
    java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<>();
    for (int num : nums) {
      pq.add(num);
      if (pq.size() > k) pq.remove(); // only keep top K elements
    }
    return pq.element();
  }



  public static void main(String[] args) {
    L_215_Kth_Largest_Element_in_an_Array solution = new L_215_Kth_Largest_Element_in_an_Array();
    int[] nums = {3,2,1,5,6,4,1,1};
    int k = 8;
    int result = solution.findKthLargest(nums, k);
    int result2 = solution.findKthLargest2(nums, k);
    int result3 = solution.findKthLargest3(nums, k);
    System.out.println(result);
  }
}
