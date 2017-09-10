package MOCK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 今日头条笔试题 - 用户喜好 on 9/10/17.
 */
public class JRTT_02 {
  private static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
  public static void main(String[] args) {
    Scanner in  = new Scanner(System.in);
    while (in.hasNext()) {
      int n = in.nextInt(); // 用户个数, (0, 3w]
      for (int i = 0; i < n; i++) {
        int howLike = in.nextInt();
        if (!map.containsKey(howLike)) {
          map.put(howLike, new ArrayList<>());
        }
        map.get(howLike).add(i);
      }

      int numOfQuery = in.nextInt();
      for (int i = 0; i < numOfQuery; i++) {
        int l = in.nextInt();
        int r = in.nextInt();
        int k = in.nextInt();

        System.out.println(run(l-1, r-1, k));
      }
    }
  }

  /**
   * 二分查找
   * 时间：O(log(N))
   * 空间：O(N)
   */
  public static int run(int l, int r, int k) {
    ArrayList<Integer> list = map.get(k);

    if (list == null || list.size() == 0) return 0;

    int left = 0;
    int right = list.size() - 1;
    while (left <= right && (list.get(left) < l || list.get(right) > r)) {
      int mid = (left + right) / 2;
      if (list.get(mid) > r) {
        right = mid - 1;
      } else if (list.get(mid) < l) {
        left = mid + 1;
      }
    }
    return right - left + 1;
  }
}
