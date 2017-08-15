package Offer;

/**
 * Created by sqfan on 8/10/17.
 */
public class O_42_Reverse_Sentence {
  /**
   * 借助String.split()分割word，和StringBuilder暂存结果。
   * 时间：O(n)
   * 空间：O(n)
   */
  public String ReverseSentence(String str) {
    String[] words = str.split("\\s+");
    StringBuilder sb = new StringBuilder();
    int t = words.length - 1;
    for (int i = str.length() -1; i >= 0; i--) {
      if (str.charAt(i) == ' ') {
        sb.append(str.charAt(i));
        continue;
      }
      sb.append(words[t--]);
      while (i >= 0 && str.charAt(i) != ' ') i--;
      if (i >= 0) sb.append(str.charAt(i));
    }
    return sb.toString();
  }

  /**
   * 不调用库函数实现翻转。
   */
  public String ReverseSentence2(String str) {
    char[] chs = new char[str.length()];
    // Reverse total sentence
    for (int i = 0; i < str.length(); i++) chs[str.length() - 1 - i] = str.charAt(i);
    // Reverse each word
    int i = 0, j = 0;
    while (j < str.length()) {
      if (chs[j] != ' ') {
        j ++;
        continue;
      }
    }
    return String.valueOf(chs);
  }
  public static void main(String[] args) {
    O_42_Reverse_Sentence solution = new O_42_Reverse_Sentence();
    String s1 = "I am happy!  ";
    String s2 = solution.ReverseSentence(s1);
    System.out.println(s2);
  }
}