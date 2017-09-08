package MOCK;

import java.util.Scanner;

/**
 * Created by sqfan on 9/8/17.
 */
public class DaJiang_01 {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    while (in.hasNext()) {
      int H = in.nextInt();
      int x = in.nextInt();
      int y = in.nextInt();
      int h = in.nextInt();
      int s = in.nextInt();
      System.out.println(getHeight(H, x, y, h, s));
    }
  }
  public static int getHeight(int H, int x, int y, int h, int s) {
    int mid = Math.min(H, h);
    int delta = x - y;
    int tmp = x * s;
    if (tmp < mid) return tmp;
    if (delta > 0) {
      double pre = mid / (double) x;
      double post = s - pre;
      return (int) Math.round(mid + post * delta);
    } else {
      return mid;
    }
  }
}
