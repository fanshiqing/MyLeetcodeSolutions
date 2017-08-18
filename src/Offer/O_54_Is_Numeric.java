package Offer;

/**
 * Created by sqfan on 8/18/17.
 */
public class O_54_Is_Numeric {
  public boolean isNumeric(char[] str) {
    if (str.length == 0) return false;
    boolean point = false;
    boolean hasE = false;
    int i = 0;
    if (str[0] == '+' || str[0] == '-') i++;
    for (; i < str.length; i++) {
      switch(str[i]) {
        case '+': case '-':
          return false;
        case '.':
          if (point) return false;
          point = true;
          break;
        case 'e': case 'E':
          if (hasE) return false;
          if (i == str.length - 1) return false; // must have subsequent!
          if (str[i+1] == '-' || str[i+1] == '+') {
            if (i+2 == str.length) return false;
            i += 1;
          }
          hasE = true;
          point = true; // NO NEED for subsequent '.'
          break;
        default:
          if (str[i] >= '0' && str[i] <= '9') continue;
          else return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    boolean isE = false;
    if (isE) System.out.println("f");
    System.out.println(1E12);
  }
}
