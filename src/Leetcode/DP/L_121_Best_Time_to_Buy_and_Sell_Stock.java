package Leetcode.DP;

/**
 * Created by sqfan on 8/21/17.
 */
public class L_121_Best_Time_to_Buy_and_Sell_Stock {
  /**
   * 1D-DP
   * Time: O(n)
   * Space: O(1)
   **/
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) return 0;
    int dp = 0;
    int maxDiff = 0;
    for (int i = 1; i < prices.length; i++) {
      dp += prices[i] - prices[i-1];
      if (dp < 0) dp = 0;
      maxDiff = Math.max(maxDiff, dp);
    }
    return maxDiff;
  }
}
