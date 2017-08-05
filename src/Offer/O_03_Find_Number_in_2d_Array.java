package Offer;

/**
 * Created by sqfan on 8/2/17.
 * 思路：每次考察右上角元素；
 *      如果相等，则找到；如果小于target,则i++；如果大于target,则j--.
 */
public class O_03_Find_Number_in_2d_Array {
  public boolean Find(int target, int[][] array) {
    int row = array.length;
    int col = array[0].length;
    int i = 0, j = col - 1;
    while (i < row && j >= 0) {
      if (array[i][j] == target) return true;
      else if (array[i][j] > target) j--;
      else i++;
    }
    return false;
  }
  public static void main(String[] args) {
    O_03_Find_Number_in_2d_Array solution = new O_03_Find_Number_in_2d_Array();
    int[][] array = {{2,4,7,9},{3,5,8,11},{4,7,11,14}};
    int[][] array2 = {{}};
    System.out.println(array2.length);
    System.out.println(array2[0].length);
    System.out.println(solution.Find(8, array));
    System.out.println(solution.Find(8, array2));
    System.out.println("hello world!");
  }
}
