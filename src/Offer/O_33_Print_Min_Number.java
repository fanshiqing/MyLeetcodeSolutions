package Offer;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by sqfan on 8/8/17.
 */
public class O_33_Print_Min_Number {
  public static String PrintMinNumber(int [] numbers) {
    ArrayList<String> list = new ArrayList<>();
    for (int a : numbers) list.add(String.valueOf(a));
    Collections.sort(list, new Comparator<String>() {
        public int compare(String o1, String o2) {
          String s1 = o1 + o2;
          String s2 = o2 + o1;
          return s1.compareTo(s2);
        }
      });
    StringBuilder sb = new StringBuilder();
    for (String s : list) sb.append(s);
    return sb.toString();
  }

  public static void main(String[] args) {
//    int[] array = {3,32,321,34};
    int[] array = {3334,3};
//    int[] array = {3, 3334};
//    int[] array = {3334,3,3333332};
    String s = PrintMinNumber(array);
    System.out.println(s);

  }
}
