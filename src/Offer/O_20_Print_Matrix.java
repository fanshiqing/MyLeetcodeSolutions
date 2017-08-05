package Offer;

import java.util.ArrayList;
import java.util.Stack;
/**
 * Created by sqfan on 8/4/17.
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class O_20_Print_Matrix {
  public static ArrayList<Integer> printMatrix(int [][] matrix) {
    int h = matrix.length;
    int w = matrix[0].length;
    ArrayList<Integer> result = new ArrayList<>();
    int left = 0, right = w - 1, top = 0, bottom = h - 1;

    while (left <= right && top <= bottom) {
      // left to right
      for (int j = left; j <= right; j++) result.add(matrix[top][j]);
      // top to bottom
      for (int i = top + 1; i <= bottom; i++) result.add(matrix[i][right]);
      // right to left
      if (top != bottom) for (int j = right - 1; j > left; j--) result.add(matrix[bottom][j]);
      // bottom to top
      if (left != right) for (int i = bottom; i > top; i--) result.add(matrix[i][left]);

      top ++;
      bottom --;
      left++;
      right--;
    }
    return result;
  }

  public static void test(ArrayList<Integer> array) {
    array.add(1);
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>();
    Stack<Integer> stk = new Stack<>();
//    int[][] matrix ={{1},{2},{3},{4}};
//    int[][] matrix ={{1,2,3,4}};
    int[][] matrix ={{1,2},{3,4}};
//    int[][] matrix ={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
    ArrayList<Integer> result = O_20_Print_Matrix.printMatrix(matrix);
    System.out.println(result);
  }
}
