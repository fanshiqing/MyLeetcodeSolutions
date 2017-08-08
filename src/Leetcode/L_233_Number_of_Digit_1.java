package Leetcode;

/**
 * Created by sqfan on 8/8/17.
 */
public class L_233_Number_of_Digit_1 {
  public int countDigitOne(int n) {
    if (n <= 0) return 0;
    int count = 0;
    int base = 1, remain, t = n;
    while (n > 0) {
      remain = n % 10;
      n = n / 10;
      if (remain > 1) count += (n + 1) * base;
      else if (remain == 1) count += (n + 0) * base + ((t % base) + 1);
      else count += n * base;
      base *= 10;
    }

    return count;
  }
}
