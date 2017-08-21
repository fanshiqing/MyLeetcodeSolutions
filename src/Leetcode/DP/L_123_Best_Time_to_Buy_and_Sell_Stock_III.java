package Leetcode.DP;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_123_Best_Time_to_Buy_and_Sell_Stock_III {
  public int maxProfit(int[] prices) {
    int hold1 = Integer.MIN_VALUE;
    int hold2 = Integer.MIN_VALUE;
    int release1 = 0;
    int release2 = 0;
    for (int price : prices) {
      release2 = Math.max(release2, hold2 + price);
      hold2 = Math.max(hold2, release1 - price);
      release1 = Math.max(release1, hold1 + price);
      hold1 = Math.max(hold1, -price);
    }
    return release2;
  }
}
