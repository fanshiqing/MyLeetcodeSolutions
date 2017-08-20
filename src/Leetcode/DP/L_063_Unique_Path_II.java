package Leetcode.DP;

/**
 * Created by sqfan on 8/20/17.
 */
public class L_063_Unique_Path_II {
  /**
   * 1D-DP
   * Time: O(m*n)
   * Space: O(m)
   */
  public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int height = obstacleGrid.length;
    int width = obstacleGrid[0].length;
    int[] dp = new int[height];
    dp[0] = 1;
    for (int j = 0; j < width; j++) {
      for (int i = 0; i < height; i++) {
        if (obstacleGrid[i][j] == 1) dp[i] = 0;
        else if (i != 0) dp[i] += dp[i-1];
      }
    }
    return dp[height-1];
  }
}
