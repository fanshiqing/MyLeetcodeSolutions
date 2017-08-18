package Offer;

/**
 * Created by sqfan on 8/18/17.
 * 用hash表保存可能出现的256个字符。按字节流出现次序顺次编号。若重复出现，则置value为负数。
 * 取值时，取value为最小正整数的key就是第一个只出现一次的字符。
 * 时间：插入：O(1);搜索：O(n)
 */
public class O_55_Frist_Non_Repeative_Char_in_Stream {
  private int[] hashTable = new int[256]; // char hash table
  private int index = 1;

  public O_55_Frist_Non_Repeative_Char_in_Stream() {
    for (int i = 0; i < 256; i++) {
      hashTable[i] = -1;
    }
  }
  //Insert one char from stringstream
  public void Insert(char ch)
  {
    if (hashTable[ch] == -1) {
      hashTable[ch] = index; // fisrt access
      index ++;
    }
    else hashTable[ch] = -2; // second or more acess
  }
  //return the first appearence once char in current stringstream
  public char FirstAppearingOnce()
  {
    int minIndex = Integer.MAX_VALUE;
    char ans = '#';
    for (int i = 0; i < 256; i++) {
      if (hashTable[i] > 0 && hashTable[i] < minIndex) {
        minIndex = hashTable[i];
        ans = (char)i;
      }
    }
    return ans;
  }
}
