package Offer;

/**
 * Created by sqfan on 8/3/17.
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class O_10_Num_Of_1_Bits {

  public int NumberOf1(int n) {
    int count = 0;
    while (n != 0) {
      count ++;
      n = n & (n - 1);
    }
    return count;
  }
  /**
   * 时间：O(1)
   * 空间：O(1)
   */
//  public int NumberOf1(int n) {
//    int count = 0;
//    for (int i = 0; i < 32; i++) {
//      if ((n & 1) == 1) count++;
//      n = n >> 1;
//    }
//    return count;
//  }

  public static void main(String[] args) {
    O_10_Num_Of_1_Bits solution = new O_10_Num_Of_1_Bits();
    System.out.println(solution.NumberOf1(0));
    System.out.println(solution.NumberOf1(1));
    System.out.println(solution.NumberOf1(7));
    System.out.println(solution.NumberOf1(-1));
    System.out.println(solution.NumberOf1(-2));


  }
}
