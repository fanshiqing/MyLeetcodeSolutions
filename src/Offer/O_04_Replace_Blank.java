package Offer;

/**
 * Created by sqfan on 8/2/17.
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 思路：从后向前扫描，先计算新空间大小，以减少字符拷贝移动次数
 */
public class O_04_Replace_Blank {

  /**
   * 在原始StringBuffer上操作
   * 时间：O(n)
   * 空间：O(1)
   * @param str
   * @return
   */
  public String replaceSpace(StringBuffer str) {
    int len = str.length();
    int numSpace = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') numSpace ++;
    }
    if (numSpace == 0) return str.toString();
    int newLen = len + 2 * numSpace; // 注意是2x,not 3x
    str.ensureCapacity(newLen);
    str.setLength(newLen);
    for (int i = len - 1, j = newLen - 1; i >= 0; i--, j--) {
      if (str.charAt(i) != ' ') str.setCharAt(j, str.charAt(i));
      else {
        str.setCharAt(j--, '0');
        str.setCharAt(j--, '2');
        str.setCharAt(j, '%');
      }
    }
    return str.toString();
  }

  /**
   * 构造临时StringBuffer
   * 时间：O(n)
   * 空间：O(n)
   * @param str
   * @return
   */
  public String replaceSpace2(StringBuffer str) {
    StringBuffer ret = new StringBuffer();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
        ret.append("%20");
      } else ret.append(str.charAt(i));
    }
    return ret.toString();
  }



  public static void main(String[] args) {
//    StringBuffer str = new StringBuffer(" !! ");
    StringBuffer str = new StringBuffer("I today! ");
    O_04_Replace_Blank solution = new O_04_Replace_Blank();
    String ret = solution.replaceSpace(str);
    System.out.println("Result:");
    System.out.println(ret);

  }
}
