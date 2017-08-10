package Offer;

/**
 * Created by sqfan on 8/10/17.
 */
public class O_42_Reverse_Sentence {
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
  public static void main(String[] args) {
    O_42_Reverse_Sentence solution = new O_42_Reverse_Sentence();
    String s1 = "I am happy!  ";
    String s2 = solution.ReverseSentence(s1);
    System.out.println(s2);
  }
}