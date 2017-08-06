package Leetcode;

/**
 * Created by sqfan on 8/6/17.
 */
public class L_067_Add_Binary {
  public String addBinary(String a, String b) {
    StringBuilder sb = new StringBuilder();
    int len = Math.max(a.length(), b.length()), len1 = a.length() - 1, len2 = b.length() - 1;
    int carry = 0, sum, i = 0;
    while (i < len || carry == 1) {
      int val1 = (i <= len1 ? (a.charAt(len1 - i) - '0') : 0);
      int val2 = (i <= len2 ? (b.charAt(len2 - i) - '0') : 0);
      sum = val1 + val2 + carry;
      carry = sum / 2;
      sb.append(sum % 2);
      i++;
    }

    return sb.reverse().toString();
  }

  public static void main(String[] args) {
    L_067_Add_Binary solution = new L_067_Add_Binary();
    String a = "100000";
//    String a = "";
//    String a = "111";
    String b = "011";

    System.out.println(solution.addBinary(a, b));
  }
}
