package Offer;

import java.util.HashSet;
/**
 * Created by sqfan on 8/10/17.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class O_34_Get_Ugly_Number {
  /**
   * Brute-force
   * Time: O(n)
   * Space: > O(n)
   */
  public int GetUglyNumber_Solution(int index) {
    HashSet<Integer> set = new HashSet<>();
    if (index <= 0) throw new IllegalArgumentException("Illegal argument");
    if (index <= 5) return index;
    for (int i = 0; i <= 5; i++) set.add(i); // [1, 5]
    index -= 5;
    int i = 5;
    while (index > 0) {
      i ++;
      if (i % 2 == 0 && set.contains(i / 2)
          || i % 3 == 0 && set.contains(i / 3)
          || i % 5 == 0 && set.contains(i / 5)) {
        set.add(i);
        index --;
      }
    }
    return i;
  }
  public static void main(String[] args) {
    O_34_Get_Ugly_Number solution = new O_34_Get_Ugly_Number();
//    System.out.println(solution.GetUglyNumber_Solution(-1));
    System.out.println(solution.GetUglyNumber_Solution(17)); // O:27
    System.out.println(solution.GetUglyNumber_Solution(100));
    System.out.println(solution.GetUglyNumber_Solution(50));

  }
}
