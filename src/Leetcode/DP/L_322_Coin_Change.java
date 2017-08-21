package Leetcode.DP;

import java.util.Arrays;

/**
 * 换钱的最小货币数
 */
public class L_322_Coin_Change {
  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) return 0;
    if (coins.length == 0) return -1;

    int[] dp = new int[amount + 1];
    int MAX_VALUE = amount + 1;
    Arrays.fill(dp, MAX_VALUE);
    dp[0] = 0;
    for (int i = 1; i <= amount; i++) {
      for (int j = 0; j < coins.length; j++) {
        if (coins[j] <= i) {
          dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
        }
      }
    }
    return (dp[amount] == MAX_VALUE ? -1 : dp[amount]);
  }

  public static void main(String[] args) {
    int[] coins = {2};
    int amount = 3;
    System.out.println(coinChange(coins, amount));
  }
}
