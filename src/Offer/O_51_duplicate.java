package Offer;

import java.util.HashSet;

/**
 * Created by sqfan on 8/17/17.
 */
public class O_51_duplicate {
  public boolean duplicate(int numbers[],int length,int [] duplication) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < length; i++) {
      if (set.contains(numbers[i])) {
        duplication[0] = numbers[i];
        return true;
      }
      set.add(numbers[i]);
    }
    return false;
  }
}
