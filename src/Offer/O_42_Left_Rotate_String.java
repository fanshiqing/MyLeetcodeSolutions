package Offer;


/**
 * Created by sqfan on 8/10/17.
 */
public class O_42_Left_Rotate_String {
  public String LeftRotateString(String str,int n) {
    if (n < 0 || str.length() == 0) return "";
    n = n % str.length(); // !!!!
    StringBuilder sb = new StringBuilder();
    for (int i = n; i < str.length(); i++) {
      sb.append(str.charAt(i));
    }
    for (int i = 0; i < n; i++) {
      sb.append(str.charAt(i));
    }
    return sb.toString();
  }
}
