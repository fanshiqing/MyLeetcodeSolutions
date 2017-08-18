package Offer;

/**
 * Created by sqfan on 8/17/17.
 * 思路：
 *  当模式中的第二个字符不是“*”时：
    1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
    2、如果字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。

   而当模式中的第二个字符是“*”时：
   如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
      1、模式后移2字符，相当于x*被忽略；
      2、字符串后移1字符，模式后移2字符； //这一步不需要执行也行，3和1串联就等于2
      3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
 */
public class O_53_Regular_Exp {
  public static boolean match(char[] str, char[] pattern)
  {
    return helper(str, 0, pattern, 0);
  }
  private static boolean helper(char[] str, int s1, char[] pat, int s2) {
    if (s1 == str.length && s2 == pat.length) return true;
    if (s1 < str.length && s2 == pat.length) return false;
    if (s1 == str.length && s2 < pat.length) {
      if (s2 + 1 < pat.length && pat[s2 + 1] == '*') return helper(str, s1, pat, s2+2);
      else return false;
    }
    // s1 < str.length && s2 < pattern.length
    if (s2+1 < pat.length && pat[s2+1] == '*') {
      if (pat[s2] == '.' || pat[s2] == str[s1]) {
        return helper(str, s1+1, pat, s2) // "*" match one character
            || helper(str, s1, pat, s2+2); // Ignore ".*"
      } else {
        return helper(str, s1, pat, s2+2); // Ignore ".*"
      }
    } else if (pat[s2] == '.' || pat[s2] == str[s1]){
      return helper(str, s1+1, pat, s2+1);
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    char[] str = "abc".toCharArray();
    char[] pattern = "abc".toCharArray();
//    System.out.println(match("abc".toCharArray(), "abc".toCharArray()));
    System.out.println(match("aaa".toCharArray(), "ab*a*c*a".toCharArray()));
//    System.out.println(match("aabc".toCharArray(),"a*.abc".toCharArray())); // true
//    System.out.println(match("aaaaaaaaaaaa".toCharArray(),"a*a".toCharArray())); // true
    System.out.println(match("aaaa".toCharArray(),"a*.aaa".toCharArray())); // true
//    System.out.println(match("abc".toCharArray(),"abc.".toCharArray())); // false
//    System.out.println(match("abcd".toCharArray(),"abc.*".toCharArray())); // true
//    System.out.println(match("abc".toCharArray(),"abc.*".toCharArray())); // true
//    System.out.println(match("".toCharArray(),".*".toCharArray())); // true
//    System.out.println(match("".toCharArray(),"".toCharArray())); // true
//    System.out.println(match("abb".toCharArray(),"a.b".toCharArray())); // true
//    System.out.println(match("abbfadfasf".toCharArray(),"a.*".toCharArray())); // true
//    System.out.println("nanjing".matches("nan.*")); //true
  }
}
