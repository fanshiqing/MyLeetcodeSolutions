package Offer;

/**
 * Created by sqfan on 8/8/17.
 * 求整数区间[1,n]中包含1的数字的个数
 * 例子：
 *      30143:
        由于3>1,则个位上出现1的次数为(3014+1)*1
        由于4>1,则十位上出现1的次数为(301+1)*10
        由于1=1，则百位上出现1次数为(30+0)*100+(43+1)
        由于0<1，则千位上出现1次数为(3+0)*1000
 */
public class O_32_Number_of_1_Between_1_and_N {

  public static int CountDigitOne(int n) {
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

  // Brute-force
  // Time: n*log(n)
  public static int NumberOf1Between1AndN_Solution(int n) {
    int ret = 0;
    for (int i = 0; i < n; i++) {
      String s = String.valueOf(n);
      for (int j = 0; j < s.length(); j++) if (s.charAt(j) == '1') ret++;
    }
    return ret;
  }

  public static void main(String[] args) {
    int n = 9979;

//    System.out.println(NumberOf1Between1AndN_Solution(n));
//    System.out.println(CountDigitOne(1));
//    System.out.println(CountDigitOne(10));
//    System.out.println(CountDigitOne(11));
//    System.out.println(CountDigitOne(99));
//    System.out.println(CountDigitOne(999));
//    System.out.println(CountDigitOne(9999));
//    System.out.println(CountDigitOne(20));
//    System.out.println(CountDigitOne(55));
    System.out.println(CountDigitOne(11));
    System.out.println(CountDigitOne(110));
//    System.out.println(CountDigitOne(233));
    char[] array = Integer.toString(n).toCharArray();
//    System.out.println("Done");
  }

}
