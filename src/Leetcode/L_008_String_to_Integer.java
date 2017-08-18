package Leetcode;

/**
 * Created by sqfan on 8/17/17.
 */
public class L_008_String_to_Integer {

  public static int myAtoi(String str) {
    if (str.length() == 0) return 0;
    int i = 0, sign = 1;
    while (str.charAt(i) == ' ') i++;
    if (str.charAt(i) == '+' || str.charAt(i) == '-') {
      sign = 1 - 2 * (str.charAt(i) == '+' ? 0 : 1);
      i++;
    }
    long result = 0; // 注意溢出
    while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
      char ch = str.charAt(i);
      if (result == 0 && ch == '0') {
        i++;
        continue;
      }
      result = result * 10 + (ch - '0');
      if (sign > 0 && result > Integer.MAX_VALUE) return Integer.MAX_VALUE; // overflow
      if (sign == -1 && -result < Integer.MIN_VALUE) return Integer.MIN_VALUE;
      i++;
    }
    return (int)result * sign;
  }

  public static void main(String[] args) {
//    System.out.println(myAtoi("1"));
    System.out.println(myAtoi("010"));
//    System.out.println(myAtoi("  +--   010 1"));
//    System.out.println(myAtoi("  +-2"));
//    System.out.println(myAtoi("1"));
//    System.out.println(myAtoi("0112addd3"));
//    System.out.println(myAtoi("123  456"));
  }
}
