package Leetcode;

/**
 * Created by sqfan on 8/7/17.
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * The input is assumed to be a 32-bit signed integer.
 *    Your function should return 0 when the reversed integer overflows.
 */
public class L_007_Reverse_Integer {

  /**
   * 思路：使用StringBuilder做reverse转换。
   * 为了防止中间结果溢出int，用long暂存
   */
  public static int reverse3(int x) {
    int sign = (x >= 0 ? 1 : -1);
    StringBuilder sb = new StringBuilder(String.valueOf(sign * (long)x));
    long tmp = Long.parseLong(sb.reverse().toString()) * sign;
    if (tmp > Integer.MAX_VALUE || tmp < Integer.MIN_VALUE) return 0;
    return (int) tmp;
  }

  /**
   * 使用long.
   */
  public static int reverse2(int x) {
    long ret = 0;
    while (x != 0) {
      ret = ret * 10 + x % 10;
      x /= 10;
    }
    if (ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;
    return (int) ret;
  }

  /**
   * 不使用long. 溢出判定：检查逆操作是否匹配旧值
   */
  public static int reverse(int x) {
    int ret = 0;
    while (x != 0) {
      int tmp = ret * 10 + x % 10;
      if ((tmp - x % 10) / 10 != ret) return 0; // check OVERFLOW!
      ret = tmp;
      x /= 10;
    }
    return ret;
  }

  public static void main(String[] args) {
    int x = -899;
//    System.out.println(reverse(x));
    System.out.println(reverse(123));
    System.out.println(reverse(-123));
    System.out.println(reverse(Integer.MAX_VALUE));
    System.out.println(reverse(Integer.MIN_VALUE));
    System.out.println(-11 % 3);

  }
}
