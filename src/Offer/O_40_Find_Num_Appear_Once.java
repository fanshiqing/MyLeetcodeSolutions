package Offer;

/**
 * Created by sqfan on 8/10/17.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class O_40_Find_Num_Appear_Once {
  /**
   * 思路：想办法把原数组分为两个子数组，每个子数组中包含一个只出现一次的数字，其他的数字都出现了两次。
   *      可以通过整个数组异或结果的最低位1来进行划分。
   */
  public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
    if (array.length <= 1) return ;
    int xor = 0;
    for (int a : array) xor ^= a;
    int res = (xor & (-xor)); // 保留最低bit=1位，其余位置0
    num1[0] = 0;
    num2[0] = 0;
    for (int a : array) {
      if ((a & res) != 0) num1[0] ^= a;
      else num2[0] ^= a;
    }
  }
  public static void main(String[] args) {
    int[] array = {1,1,2,3,2,4,4,5,5,8,7,7};
    int[] num1 = new int[1];
    int[] num2 = new int[1];
    O_40_Find_Num_Appear_Once solution = new O_40_Find_Num_Appear_Once();
    solution.FindNumsAppearOnce(array, num1, num2);
    System.out.println(num1[0] + ", " + num2[0]);
  }
}
