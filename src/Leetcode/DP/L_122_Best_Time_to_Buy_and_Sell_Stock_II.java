package Leetcode.DP;

/**
 * Created by sqfan on 8/21/17.
 * 贪心
 */
public class L_122_Best_Time_to_Buy_and_Sell_Stock_II {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;
    int maxProfit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i-1]) {
        maxProfit += prices[i] - prices[i-1];
      }
    }
    return maxProfit;
  }
}
