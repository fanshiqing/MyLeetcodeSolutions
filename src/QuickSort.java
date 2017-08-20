import java.util.Stack;

/**
 * Created by sqfan on 8/11/17.
 * (1) 快速排序
 * (2) 快速排序的非递归实现
 * (3) 链表的快速排序
 */
public class QuickSort {
  /////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * (1) 递归实现的快速排序
   * 基本思想：通过一趟排序将待排记录分割成独立的两部分,其中一部分记录的关键字均比另一部分记录的关键字小,
   *          则可分别对这两部分记录继续进行排序，已达到整个  序列有序.
   * 平均时间：O(nlog(n))
   * 最坏时间：O(n^2)
   */
  public void quickSort(int[] nums, int left, int right) {
    if (left < right) {
      int split = partition(nums, left, right);
      quickSort(nums, left, split - 1);
      quickSort(nums, split + 1, right);
    }
  }
  public int partition(int[] nums, int left, int right) {
    int pivot = nums[left];
    int split = left;
    for (int i = left + 1; i <= right; i++) {
      if (nums[i] < pivot) {
        split ++;
        if (i != split) swap(nums, i, split);
      }
    }
    swap(nums, left, split);
    return split;
  }
  public static void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  /////////////////////////////////////////////////////////////////////////////////////////////////
  /**
   * (2) 使用栈的非递归实现：用栈保存每一个待排序子串的首尾元素下标
   */
  public void quickSort_NonRecursive(int[] nums, int left, int right) {
    Stack<Integer> stack = new Stack<>();
    stack.push(right);
    stack.push(left);
    while (!stack.isEmpty()) {
      left = stack.pop();
      right = stack.pop();
      if (left < right) {
        int split = partition(nums, left, right);
        // right part
        stack.push(right);
        stack.push(split + 1);
        // left part
        stack.push(split - 1);
        stack.push(left);
      }
    }
  }
  /////////////////////////////////////////////////////////////////////////////////////////////////
  public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }
  /**
   * 链表的快速排序。对于单链表的快速排序，不能从后面开始遍历，因为根据后继找不到其前驱。因此采用以下步骤：
   *    1.取每次的头节点为基准节点，然后将这个节点从链表分离出来。用两个指针，从头节点的下一个节点遍历。
   *    2.找到一个小于头节点的值，若是第一个小于头节点的值，左链表的头指向它，然后继续遍历，满足小于就
   *      挂载在左链表的后面。相反，创建一个有链表。其实还是在原链表上创建。
   *    3.使用递归分别对左链表和右链表进行如上操作，当头节点为NULL时，递归返回。当左右链表都返回时，
   *      将原来的头节点与左右链表挂上。
   * 链表的Partition操作实现见L_086_Partition_List.
   *
   * 时间：O(nlog(n))
   * 空间：O(1)
   */
  public ListNode quickSort_List(ListNode head) {
    if (head == null || head.next == null) return head;

    int pivot = head.val;
    ListNode[] partition = partition_List(head.next, pivot);
    ListNode pLt = quickSort_List(partition[0]); // less than pivot list
    ListNode pGe = quickSort_List(partition[1]); // greater or equal than pivot list

    head.next = pGe;
    ListNode p = pLt;
    while (p != null && p.next != null) p = p.next;
    if (p != null) {
      p.next = head;
      return pLt;
    } else {
      return head;
    }
  }

  private ListNode[] partition_List(ListNode head, int pivot) {
    if (head == null) return null;

    ListNode ltList = new ListNode(-1);
    ListNode geList = new ListNode(-1);
    ListNode p1 = ltList, p2 = geList;
    while (head != null) {
      if (head.val < pivot) {
        p1.next = head;
        p1 = p1.next;
      } else {
        p2.next = head;
        p2 = p2.next;
      }
      head = head.next;
    }
    p1.next = null;
    p2.next = null;
    return new ListNode[] {ltList.next, geList.next};
  }

  public static void main(String[] args) {
//    int[] nums = {2,3,4,1,4,4,6,-1};
    QuickSort solution = new QuickSort();
//    solution.quickSort(nums, 0, nums.length - 1);
//    for(int num : nums) {
//      System.out.print(num + ", ");
//    }
//    System.out.println();
//    solution.quickSort_NonRecursive(nums, 0, nums.length - 1);
//    for(int num : nums) {
//      System.out.print(num + ", ");
//    }

    ListNode head = new ListNode(5);
    head.next = new ListNode(4);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(7);
    head.next.next.next.next = new ListNode(-1);
    ListNode result = solution.quickSort_List(head);
    while (result != null) {
      System.out.print(result.val + ", ");
      result = result.next;
    }
  }
}
