package Leetcode;

/**
 * Created by sqfan on 8/28/17.
 */
public class L_657_Judge_Route_Circle {
  public boolean judgeCircle(String moves) {
    int[] count = new int[2];
    for (int i = 0; i < moves.length(); i++) {
      switch(moves.charAt(i)) {
        case 'U':
          count[0]++;
          break;
        case 'D':
          count[0]--;
          break;
        case 'L':
          count[1]++;
          break;
        case 'R':
          count[1]--;
          break;
        default:
          throw new IllegalArgumentException();
      }
    }
    return count[0] == 0 && count[1] == 0;
  }
}
