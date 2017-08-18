package Offer;

/**
 * Created by sqfan on 8/17/17.
 */
public class O_49_String_to_Integer {
  public static int StrToInt(String str) {
    if (str.length() == 0) return 0;
    int i = 0;
    int sign = 1;
    long result = 0; // 注意溢出
    if (str.charAt(i) == '+') {
      i ++;
    } else if (str.charAt(i) == '-') {
      sign *= -1;
      i ++;
    }
    for ( ; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch < '0' || ch > '9') return 0;
      if (result == 0 && ch == '0') continue;
      result = result * 10 + (ch - '0');
      if (sign == 1 && result > Integer.MAX_VALUE) return 0; // overflow
      if (sign == -1 && -result < Integer.MIN_VALUE) return 0;
    }
    return (int)result * sign;
  }
  public static void main(String[] args) {
    String str = "-1111111111";
    System.out.println(StrToInt(str));

  }
}
