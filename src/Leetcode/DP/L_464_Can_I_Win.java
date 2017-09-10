package Leetcode.DP;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 在“100游戏”中，两个玩家轮流从整数1-10中取数相加，得到一个累加值。第一个使累加值达到或者超过100的玩家获胜。
 * 用过的数字不能重复使用。
 *    例如，两个玩家可以轮流从1..15中无放回的取数字，使得累加值>=100。
 *    给定整数 maxChoosableInteger 和 desiredTotal，判断第一个玩家是否一定能赢，假设两名玩家都采用最优策略。
 *    你可以总是假设 maxChoosableInteger 不大于20，desiredTotal 不大于300。
 *
 * 解法：DFS搜索。为了避免递归调用过程中子问题的重复计算，使用Hash表来记录之前已经计算好的结果。
 *      （注意：对于一个boolean[]类型，Arrays.toString()返回字符串[true,false,true,....]
 *        可以直接作为map的key）
 */
public class L_464_Can_I_Win {
  private HashMap<Integer, Boolean> cache;
  /**
   * 回溯解法。
   * 时间：最多所有子问题都计算过，每个number选择有0/1两种，共O(2^n); 若不用cache,时间为O(!n)
   * 空间：O(2^n)
   * @param maxChoosableInteger
   * @param desiredTotal
   * @return
   */
  public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
    if (desiredTotal <= 0) return true;
    if (desiredTotal > (maxChoosableInteger) * (maxChoosableInteger+1) / 2) return false;

    boolean[] isUsed = new boolean[maxChoosableInteger + 1];
    this.cache = new HashMap<>();
    return dfs(isUsed, desiredTotal);
  }

  private boolean dfs(boolean[] isUsed, int desiredTotal) {
    if (desiredTotal <= 0) return false;

//    String state = Arrays.toString(isUsed);
    int state = format(isUsed);
    if (cache.containsKey(state)) return cache.get(state);

    // Check every unchosen number at next step
    for (int i = 1; i < isUsed.length; i++) {
      if (!isUsed[i]) {
        isUsed[i] = true;
        if (desiredTotal - i <= 0 || !dfs(isUsed, desiredTotal - i)) {
          isUsed[i] = false;
          cache.put(state, true);
          return true;
        }
        isUsed[i] = false; // 回溯
      }
    }
    cache.put(state, false);
    return false;
  }

  /**
   * Boolean[] array to integer.
   * @param state
   * @return
   */
  private int format(boolean[] state) {
    int ret = 0;
    for (int i = 0; i < state.length; i++) {
      ret <<= 1;
      if (state[i]) {
        ret |= 1;
      }
    }
    return ret;
  }
  public static void main(String[] args) {
    L_464_Can_I_Win solution = new L_464_Can_I_Win();
//    boolean[] state = new boolean[3];
//    System.out.println(Arrays.toString(state));
//    System.out.println(state);
    System.out.println(solution.canIWin(10, 11));
    System.out.println(solution.canIWin(18, 171));
  }
}
