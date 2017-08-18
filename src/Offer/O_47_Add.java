package Offer;

/**
 * Created by sqfan on 8/17/17.
 */
public class O_47_Add {
  public static int Add(int a,int b) {
    while (a != 0) {
      int t = (a & b) << 1;
      b = a ^ b;
      a = t;
    }
    return b;
  }
  public static void main(String[] args) {
    int a = 11;
    int b = 4;
    System.out.println(Add(a, b));
    System.out.println(Add(b, a));
  }
}
