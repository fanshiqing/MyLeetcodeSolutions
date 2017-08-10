package Offer;

import java.util.HashMap;
/**
 * Created by sqfan on 8/10/17.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class O_35_First_Not_Repeat_Char {
  // Time: O(length(str))
  // Space: O(1) // 因为key最多是26个英文字母，因此可以直接new int[26]而不用hashmap
  public int FirstNotRepeatingChar(String str) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < str.length(); i++) {
      if (map.containsKey(str.charAt(i))) map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
      else map.put(str.charAt(i), 1);
    }
    for (int i = 0; i < str.length(); i++) {
      if (map.get(str.charAt(i)) == 1) return i;
    }
    return -1; // Not found
  }

  public static void main(String[] args) {
    HashMap<Character, Integer> map = new HashMap<>();
    map.put('a', map.get('a') + 1);
    System.out.println("Done!");
  }
}
