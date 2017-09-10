package MOCK;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 今日头条笔试题1- 手串 on 9/10/17.
 */
public class JRTT_01 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int n = in.nextInt(); // 串珠的个数,每个珠子要么无色，要么涂了若干种颜色,[1, 1w]
      int m = in.nextInt(); // 任意连续m长串里任意颜色（不含无色）最多出现一次,[1,1k]
      int c = in.nextInt(); // 手串上的颜色种类,[1,50]

      HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
      for (int i  = 0; i < n; i++) {
        int ithColorNum = in.nextInt(); // [0,c]
        for (int j = 0; j < ithColorNum; j++) {
          int color = in.nextInt(); // [1, c]
          if (!map.containsKey(color)) {
            map.put(color, new ArrayList<>());
          }
          map.get(color).add(i - 1); // indexed from ZERO
        }
      }

      int count = run(map, n, m);

      System.out.println(count);
    }
  }

  public static int run(HashMap<Integer, ArrayList<Integer>> map, int n, int m) {
    int count = 0;

    for (ArrayList<Integer> list : map.values()) {
      if (conflict(list, n, m)) count ++;
    }

    return count;
  }

  public static boolean conflict(ArrayList<Integer> list, int n, int m) {
    if (list.size() <= 1) return false;
    int firstIndex = list.get(0), prevIndex = list.get(0);
    int minIterval = Integer.MAX_VALUE;
    for (int i = 1; i < list.size(); i++) {
      minIterval = Math.min(minIterval, list.get(i) - prevIndex);
      prevIndex = list.get(i);
      if (minIterval < m) return true;
    }
    return (n - prevIndex) + firstIndex < m;
  }
}
