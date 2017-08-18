package Offer;

/**
 * Created by sqfan on 8/15/17.
 */
public class O_44_Is_Continuous {
  public boolean isContinuous(int [] numbers) {
    if (numbers.length != 5) return false;
    java.util.Arrays.sort(numbers);
    int i = 0;
    while (i < numbers.length && numbers[i] == 0) i++;
    int numOfZeros = i;
    while (i < numbers.length -  1) {
      if (numbers[i] == numbers[i + 1]) return false;
      if (numbers[i] + 1 == numbers[i + 1]) i++;
      else if (numbers[i + 1] - numbers[i] - 1 <= numOfZeros) {
        numOfZeros -= numbers[i + 1] - numbers[i] - 1;
        i++;
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,6,0,0};
    O_44_Is_Continuous solution = new O_44_Is_Continuous();
    System.out.println(solution.isContinuous(nums));
  }
}
