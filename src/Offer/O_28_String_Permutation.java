package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by sqfan on 8/6/17.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 *    例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *    输入描述：输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 *
 * 思路：1.输入str排序，方便下一步去重；
 *      2.在递归操作生成全排列项过程中去重；(a[ab]和a[bb]两种case)
 *      3.出来结果已基本有序且无重，再用Collections.sort()排序
 */
public class O_28_String_Permutation {
  public static ArrayList<String> Permutation(String str) {
    ArrayList<String> result = new ArrayList<>();
    char[] array = str.toCharArray();
    Arrays.sort(array);
    Helper(array, 0, result);
    Collections.sort(result, String.CASE_INSENSITIVE_ORDER);
    return result;
  }

  private static void Helper(char[] str, int begin, ArrayList<String> list) {
    if (begin == str.length - 1) {
      list.add(new String(str));
      return ;
    }
    for (int i = begin; i < str.length; i++) {
      if (i != begin && str[begin] == str[i]) continue; // skip DUPLICATE items like "a[ab]"
      if (i > begin + 1 && i < str.length && str[i] == str[i - 1]) continue; // skip DUPLICATE items
                                                                            // like "a[bb]"
      char tmp = str[begin];
      str[begin] = str[i];
      str[i] = tmp;

      Helper(str, begin + 1, list);

      tmp = str[begin];
      str[begin] = str[i];
      str[i] = tmp;
    }
  }

  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("abc");
    list.add("dongjing");
    list.add("Dongjing");
    list.add("beijing");
    Collections.sort(list);
    System.out.println(list);
    Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
    System.out.println(list);
    char[] chars = "cba".toCharArray();
    Arrays.sort(chars);

    String str = "abb";
//    String str = "bab";
//    String str = "aAbaa";
//    String str = "aabaa";
//    String str = "";
//    String str = "ddda";
//    String str = "dd";
    ArrayList<String> result = Permutation(str);
    System.out.println(result);
  }
}
